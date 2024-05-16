package com.sdechcode.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@SpringBootTest
class SpringSecurityDemoApplicationTests {

    @Test
    void contextLoads() {
        String userRoles = "admin user";
        String[] roles = StringUtils.tokenizeToStringArray(userRoles, " ");
        Arrays.stream(roles).forEach(System.out::println);
        System.out.println("--------------------------------");

        Arrays.stream(roles)
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .forEach(System.out::println);
    }

}
