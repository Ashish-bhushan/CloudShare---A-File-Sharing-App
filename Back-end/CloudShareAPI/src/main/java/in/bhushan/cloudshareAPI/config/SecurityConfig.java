package in.bhushan.cloudshareAPI.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import in.bhushan.cloudshareAPI.security.ClerkJWTAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{

	 private final ClerkJWTAuthFilter clerkJWTAuthFilter;
	
	public SecurityConfig(ClerkJWTAuthFilter clerkJWTAuthFilter) {
        this.clerkJWTAuthFilter = clerkJWTAuthFilter;
    }
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> {}) // Spring will use the CorsFilter bean
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/webhooks/**").permitAll()
                .anyRequest().authenticated()
            )
        	.addFilterBefore(clerkJWTAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    public CorsFilter corsFilter()
    {
    	return new CorsFilter(CorsConfigurationSource());
    }
    
    @Bean
    public UrlBasedCorsConfigurationSource CorsConfigurationSource() {

        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedOrigins(Arrays.asList("*"));
        corsConfig.setAllowedHeaders(Arrays.asList("*"));
        corsConfig.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        corsConfig.setExposedHeaders(Arrays.asList("Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return source;
    }
}
