package com.example.security_and_jwt.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/test")
    public String testMessage(){
        return "this is a test message!";
    }
}
