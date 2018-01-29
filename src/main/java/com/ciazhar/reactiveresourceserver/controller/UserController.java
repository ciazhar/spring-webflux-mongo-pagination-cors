package com.ciazhar.reactiveresourceserver.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciazhar.reactiveresourceserver.model.User;
import com.ciazhar.reactiveresourceserver.repo.UserRepo;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserRepo repo;

    @GetMapping("/all")
    public Flux<User> all(final @RequestParam int page, final @RequestParam int size){
        return repo.retrieveAllUsersPaged(PageRequest.of(page, size))
            .delayElements(Duration.ofMillis(100));
    }
    
}