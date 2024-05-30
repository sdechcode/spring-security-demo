package com.sdechcode.springsecuritydemo.system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DBDataInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

}
