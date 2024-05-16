package com.sdechcode.springsecuritydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
                         * only the admin can access admin resources
                         * */
                        .requestMatchers("/api/v1/admin").hasAuthority("admin")

                        /*
                         * only admin and user can access user resources
                         * */
                        .requestMatchers("/api/v1/user").hasAnyAuthority("admin", "user")

                        /*
                         * all other requests are authenticated
                         * */
                        .anyRequest().authenticated()
                )
                /*
                 * enable default login form spring security
                 * */
                .formLogin(Customizer.withDefaults())
                /*
                * tell spring security to use InMemoryUserDetailsManager for authentication
                * */
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("admin")
                .build();
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                .authorities("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
