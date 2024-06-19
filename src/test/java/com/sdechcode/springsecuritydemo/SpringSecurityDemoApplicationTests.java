package com.sdechcode.springsecuritydemo;

import com.sdechcode.springsecuritydemo.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityDemoApplicationTests {

    @Test
    void contextLoads() {
        Car c1 = new Car("Toyota", 20000);
        String s = JsonUtil.object2Json(c1);
        System.out.println(s);
    }

}

record Car(String model, Integer price){}