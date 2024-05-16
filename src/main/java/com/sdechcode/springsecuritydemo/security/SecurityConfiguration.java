package com.sdechcode.springsecuritydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        /*
                         * allow all to access guest resources
                         * */
                        .requestMatchers("/api/v1/guest").permitAll()

                        /*
                        * explicitly fallback to antMatcher inside requestMatchers.
                        * */
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()

                        /*
                         * only the admin can access admin resources
                         * */
                        .requestMatchers("/api/v1/admin").hasAuthority("ROLE_admin")

                        /*
                         * only admin and user can access user resources
                         * */
                        .requestMatchers("/api/v1/user").hasAnyAuthority("ROLE_admin", "ROLE_user")

                        /*
                         * all other requests are authenticated
                         * */
                        .anyRequest().authenticated()
                )
                /*
                * this is for H2 browser console access.
                * */
                .headers(headers -> headers.frameOptions(Customizer.withDefaults()).disable())
                /*
                 * disable csrf protection
                 */
                .csrf(AbstractHttpConfigurer::disable)
                /*
                * tell spring security to use UserDetails for authentication
                * */
                .httpBasic(Customizer.withDefaults())
                /* Configures the spring boot application as an OAuth2 Resource Server which authenticates all
                 the incoming requests (except the ones excluded above) using JWT authentication.
                 */
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
