package com.LetsCodeIt.Secure.Bank.System.controller;

import com.LetsCodeIt.Secure.Bank.System.entity.UserEntity;
import com.LetsCodeIt.Secure.Bank.System.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final UserRepository userRepository;
    public AdminController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers(){
        List<UserEntity> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }
}
