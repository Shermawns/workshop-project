package com.Shermawn.demo.config;

import com.Shermawn.demo.models.UserModel;
import com.Shermawn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()){
            UserModel u1 = new UserModel(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
            UserModel u2 = new UserModel(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

            userRepository.saveAll(Arrays.asList(u1,u2));
        }
    }
}
