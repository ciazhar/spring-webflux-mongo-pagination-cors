package com.ciazhar.reactiveresourceserver.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
public class User {

    private String id;
    private String name;
    private String username;
    private String password;
    
}