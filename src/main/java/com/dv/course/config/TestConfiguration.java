package com.dv.course.config;

import com.dv.course.entities.*;
import com.dv.course.entities.enuns.OrderStatus;
import com.dv.course.repositories.*;
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

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Jhon Tompson","tom@gmail.com","2345-2299","xxxxx");
        User user2 = new User("Ana Lisa","analisa@gmail.com","2345-2299","xxxxx");

        Order order1 = new Order(null, Instant.now(), user1, OrderStatus.SHIPPED);
        Order order2 = new Order(null, Instant.now(), user2,OrderStatus.DELIVERED);
        Order order3 = new Order(null, Instant.now(), user1,OrderStatus.PAID);

        Product p1 = new Product(null,"XBOX","X-box lançamento",3500.0,"produto sem imagem");
        Product p2 = new Product(null,"Mini game","Mini game psvita",1500.0,"produto sem imagem");
        Product p3 = new Product(null,"Panela Eletrica","Panela eletrica 5 litros",500.0,"produto sem imagem");
        Product p4 = new Product(null,"Caixa de som UBL","Som mega potente",5300.0,"produto sem imagem");
        Product p5 = new Product(null,"Toalha de Banho","Toalha de linha",53.0,"produto sem imagem");


        Category category1 = new Category(null,"Games");
        Category category2 = new Category(null,"Eltro");
        Category category3 = new Category(null,"Cozinha");
        Category category4 = new Category(null,"Cama-mesa-banho");

        p1.getCategories().add(category1);
        p2.getCategories().add(category1);
        p3.getCategories().add(category3);
        p4.getCategories().add(category2);
        p5.getCategories().add(category4);


        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRespository.saveAll(Arrays.asList(order1,order2,order3));
        categoryRepository.saveAll(Arrays.asList(category1,category2,category3,category4));
        productsRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        OrderItem orderItem1 = new OrderItem(order1,p1,2, p1.getPrice());
        OrderItem orderItem2 = new OrderItem(order2,p2,1,p2.getPrice());
        OrderItem orderItem3 = new OrderItem(order3,p3,10,p3.getPrice());
        OrderItem orderItem4 = new OrderItem(order1,p1,1,p1.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1,orderItem2,orderItem3,orderItem4));

        Payment payment1 = new Payment(null,Instant.now(),order3);
        order3.setPayment(payment1);

        orderRespository.save(order3);
    }
}
