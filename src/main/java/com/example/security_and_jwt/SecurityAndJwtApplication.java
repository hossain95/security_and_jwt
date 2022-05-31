package com.example.security_and_jwt;

import com.example.security_and_jwt.domain.Account;
import com.example.security_and_jwt.domain.Role;
import com.example.security_and_jwt.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityAndJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityAndJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    CommandLineRunner run(AccountService accountService){
//        return args -> {
//            accountService.saveRole(new Role(null, "ROLE_USER"));
//            accountService.saveRole(new Role(null, "ROLE_MANAGER"));
//            accountService.saveRole(new Role(null, "ROLE_ADMIN"));
//            accountService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//
//            accountService.saveAccount(new Account(null, "Mia Hossain", "hossain", "1234", new ArrayList<>()));
//            accountService.saveAccount(new Account(null, "Akter Hossain", "akter", "1234", new ArrayList<>()));
//            accountService.saveAccount(new Account(null, "Roma Akter", "roma", "1234", new ArrayList<>()));
//            accountService.saveAccount(new Account(null, "Sabina Akter", "sabina", "1234", new ArrayList<>()));
//
//            accountService.addRoleToAccount("hossain", "ROLE_USER");
//            accountService.addRoleToAccount("hossain", "ROLE_MANAGER");
//            accountService.addRoleToAccount("hossain", "ROLE_SUPER_ADMIN");
//            accountService.addRoleToAccount("akter", "ROLE_ADMIN");
//            accountService.addRoleToAccount("roma", "ROLE_ADMIN");
//            accountService.addRoleToAccount("sabina", "ROLE_ADMIN");
//            accountService.addRoleToAccount("sabina", "ROLE_USER");
//        };
//    }
}
