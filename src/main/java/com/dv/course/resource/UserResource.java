package com.dv.course.resource;

import com.dv.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<?> getList(){
        User u = new User("Vegeta","vegeta@gmail.com","2344-3300","xxxxxxxxxxx");
        return ResponseEntity.ok().body(u);
    }

}
