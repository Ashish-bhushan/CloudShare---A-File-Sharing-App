package in.bhushan.cloudshareAPI.security;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class ClerkJWKSProvider {

    @Value("${clerk.jwks-url}")
    private String jwksUrl;

    private final Map<String, PublicKey> keyCache = new HashMap<>();
    private long lastFetchTime = 0;

    private static final long CACHE_TTL = 3600000; // 1 hour

    public PublicKey getPublicKey(String kid) throws Exception {
        if (keyCache.containsKey(kid)
                && System.currentTimeMillis() - lastFetchTime < CACHE_TTL) {
            return keyCache.get(kid);
        }

        refreshKeys();
        return keyCache.get(kid);
    }

    private void refreshKeys() throws Exception {
    	ObjectMapper mapper = new ObjectMapper();

        URL url = new URL(jwksUrl);
        JsonNode jwks;
        try (InputStream is = url.openStream()) {
            jwks = mapper.readTree(is);
        }

        JsonNode keys = jwks.get("keys");
        if (keys == null || !keys.isArray()) {
            throw new IllegalStateException("Invalid JWKS response");
        }

        keyCache.clear();

        for (JsonNode keyNode : keys) {
            String kid = keyNode.get("kid").asText();
            String kty = keyNode.get("kty").asText();

            if (!"RSA".equals(kty)) {
                continue;
            }

            String n = keyNode.get("n").asText();
            String e = keyNode.get("e").asText();

            PublicKey publicKey = buildRsaPublicKey(n, e);
            keyCache.put(kid, publicKey);
        }

        lastFetchTime = System.currentTimeMillis();
    }

    private PublicKey buildRsaPublicKey(String n, String e) throws Exception {
        byte[] modulusBytes = Base64.getUrlDecoder().decode(n);
        byte[] exponentBytes = Base64.getUrlDecoder().decode(e);

        BigInteger modulus = new BigInteger(1, modulusBytes);
        BigInteger exponent = new BigInteger(1, exponentBytes);

        RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);
        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }
}
