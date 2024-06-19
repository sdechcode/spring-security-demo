package com.sdechcode.springsecuritydemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringSecurityDemoApplicationTests {

    @Test
    void contextLoads() {

    }

}

record Car(String model, Integer price){}