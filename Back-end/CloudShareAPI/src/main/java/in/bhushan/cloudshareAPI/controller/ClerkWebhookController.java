package in.bhushan.cloudshareAPI.controller;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svix.Webhook;
import com.svix.exceptions.WebhookVerificationException;

import in.bhushan.cloudshareAPI.DTO.ProfileDTO;
import in.bhushan.cloudshareAPI.repository.UserCreditRepository;
import in.bhushan.cloudshareAPI.service.ProfileService;
import in.bhushan.cloudshareAPI.service.UserCreditService;

@RestController
@RequestMapping("/webhooks")
public class ClerkWebhookController {

    private final UserCreditRepository userCreditRepository;

    @Value("${clerk.webhook.secret}")
    private String webhookSecret;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ProfileService profileService;
    private final UserCreditService userCreditService;

    public ClerkWebhookController(ProfileService profileService,UserCreditService userCreditService, UserCreditRepository userCreditRepository) {
        this.profileService = profileService;
        this.userCreditService = userCreditService;
        this.userCreditRepository = userCreditRepository;
    }

    @PostMapping("/clerk")
    public ResponseEntity<?> handleClerkWebhook(
            @RequestHeader("svix-id") String svixId,
            @RequestHeader("svix-timestamp") String svixTimestamp,
            @RequestHeader("svix-signature") String svixSignature,
            @RequestBody String payload
    ) 
    {
        System.out.println("🚀 STEP 1: Clerk webhook received");

        try {
            Webhook webhook = new Webhook(webhookSecret);

            Map<String, List<String>> headerMap = Map.of(
                    "svix-id", List.of(svixId),
                    "svix-timestamp", List.of(svixTimestamp),
                    "svix-signature", List.of(svixSignature)
            );

            HttpHeaders headers = HttpHeaders.of(headerMap, (k, v) -> true);

            System.out.println("🔐 STEP 2: Verifying webhook");
            webhook.verify(payload, headers);
            System.out.println("✅ STEP 3: Webhook verified");

            JsonNode rootNode = objectMapper.readTree(payload);
            String eventType = rootNode.path("type").asText();
            JsonNode dataNode = rootNode.path("data");

            if ("user.created".equals(eventType)) {
                System.out.println("📦 STEP 4: user.created event");
                handleUserCreated(dataNode);
            }

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Webhook failed");
       }

    /* ===================== EVENT HANDLERS ===================== */

    private void handleUserCreated(JsonNode data) {
        String clerkId = data.path("id").asText();
        String firstName = data.path("first_name").asText("");
        String lastName = data.path("last_name").asText("");
        String imageUrl = data.path("image_url").asText("");

        String email = data.path("email_addresses")
                .path(0)
                .path("email_address")
                .asText("");

        ProfileDTO newProfile = ProfileDTO.builder()
                .clerkId(clerkId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .photoUrl(imageUrl)
                .build();

        profileService.createProfile(newProfile);
        userCreditService.createInitialCredits(clerkId);
        System.out.println("Profile created for Clerk user: " + clerkId);
    }

    private void handleUserUpdated(JsonNode data) {
        String clerkId = data.path("id").asText();
        String firstName = data.path("first_name").asText("");
        String lastName = data.path("last_name").asText("");
        String imageUrl = data.path("image_url").asText("");
        String email = data.path("email_addresses")
                           .path(0)
                           .path("email_address")
                           .asText("");

        // Updated profile DTO
        ProfileDTO updatedProfile = ProfileDTO.builder()
                .clerkId(clerkId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .photoUrl(imageUrl)
                .build();

        profileService.updateProfile(updatedProfile);
        System.out.println("Profile updated for Clerk user: " + clerkId);
    }

    private void handleUserDeleted(JsonNode data) {
        String clerkId = data.path("id").asText();
        profileService.deletedProfile(clerkId);
        System.out.println("Profile deleted for Clerk user: " + clerkId);
    }
}
