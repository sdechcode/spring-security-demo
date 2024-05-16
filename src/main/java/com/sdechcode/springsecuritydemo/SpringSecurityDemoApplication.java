package com.sdechcode.springsecuritydemo;

import com.sdechcode.springsecuritydemo.user.UserEntity;
import com.sdechcode.springsecuritydemo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    /*
    * After the application has been start it will create 3 users into h2
    * */
    @Override
    public void run(String... args) throws Exception {
        // Create some users.
        UserEntity u1 = new UserEntity();
        u1.setId(1);
        u1.setUsername("admin");
        u1.setPassword(encoder.encode("admin"));
        u1.setEnabled(true);
        u1.setRoles("admin user");

        UserEntity u2 = new UserEntity();
        u2.setId(2);
        u2.setUsername("user");
        u2.setPassword(encoder.encode("user"));
        u2.setEnabled(true);
        u2.setRoles("user");

        UserEntity u3 = new UserEntity();
        u3.setId(3);
        u3.setUsername("tom");
        u3.setPassword(encoder.encode("qwerty"));
        u3.setEnabled(false);
        u3.setRoles("user");

        this.userRepository.save(u1);
        this.userRepository.save(u2);
        this.userRepository.save(u3);
    }

}
