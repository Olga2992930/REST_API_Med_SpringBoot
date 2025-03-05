package se.deved.apiApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .oauth2Login(oauth -> {
                    oauth.successHandler(((request, response, authentication) -> {
                        System.out.println("VI LYCKADES!");

                        OAuth2User user = (OAuth2User) authentication.getPrincipal();

                        user.getAttributes().forEach((key, value) -> {
                            System.out.println(key + ": " + value);
                        });

                        response.getWriter().println("Du är inloggad!");
                    }));
                });

        return http.build();
    }
}
