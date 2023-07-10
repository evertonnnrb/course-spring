package com.dv.course.config;

import com.dv.course.entities.User;
import com.dv.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Jhon Tompson","tom@gmail.com","2345-2299","xxxxx");
        User user2 = new User("Ana Lisa","analisa@gmail.com","2345-2299","xxxxx");
        //repository.saveAll(Arrays.asList(user1,user2));
        repository.save(user1);
        repository.save(user2);
    }
}
