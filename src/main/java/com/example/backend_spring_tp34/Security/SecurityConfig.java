package com.example.backend_spring_tp34.Security;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(registry ->
                registry.requestMatchers("/").permitAll()
                        .requestMatchers("/rendezvous").hasRole("ADMIN")
                        .requestMatchers("/personnes").hasRole("User")
                        .anyRequest().authenticated()
        ).oauth2ResourceServer(oauth2Configurer -> oauth2Configurer
                .jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwt -> {
                    Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
                    Collection<String> roles = (realmAccess != null) ? realmAccess.get("roles") : List.of();
                    List<SimpleGrantedAuthority> grantedAuthorities = roles.stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList();

                    grantedAuthorities.forEach(authority -> logger.info("Granted authority: {}", authority.getAuthority()));
                    return new JwtAuthenticationToken(jwt, grantedAuthorities);
                }))
        );
        return httpSecurity.build();
    }
}
