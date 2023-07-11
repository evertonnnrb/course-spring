package com.dv.course.config;

import com.dv.course.entities.Category;
import com.dv.course.entities.Order;
import com.dv.course.entities.User;
import com.dv.course.entities.enuns.OrderStatus;
import com.dv.course.repositories.CategoryRepository;
import com.dv.course.repositories.OrderRespository;
import com.dv.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRespository orderRespository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Jhon Tompson","tom@gmail.com","2345-2299","xxxxx");
        User user2 = new User("Ana Lisa","analisa@gmail.com","2345-2299","xxxxx");

        Order order1 = new Order(null, Instant.now(), user1, OrderStatus.SHIPPED);
        Order order2 = new Order(null, Instant.now(), user2,OrderStatus.DELIVERED);
        Order order3 = new Order(null, Instant.now(), user1,OrderStatus.PAID);

        Category category1 = new Category(null,"PC");
        Category category2 = new Category(null,"Notebook");
        Category category3 = new Category(null,"Tablet");

        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRespository.saveAll(Arrays.asList(order1,order2,order3));
        categoryRepository.saveAll(Arrays.asList(category1,category2,category3));
    }
}
