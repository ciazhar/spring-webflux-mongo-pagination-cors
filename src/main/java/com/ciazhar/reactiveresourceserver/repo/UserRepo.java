package com.ciazhar.reactiveresourceserver.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ciazhar.reactiveresourceserver.model.User;

import reactor.core.publisher.Flux;

public interface UserRepo extends ReactiveMongoRepository<User,String>{
    @Query("{ id: { $exists: true }}")
    Flux<User> retrieveAllUsersPaged(final Pageable pageable);
}