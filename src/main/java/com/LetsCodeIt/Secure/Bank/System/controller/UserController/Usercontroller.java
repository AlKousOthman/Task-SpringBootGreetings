package com.LetsCodeIt.Secure.Bank.System.controller.UserController;

import com.LetsCodeIt.Secure.Bank.System.bo.user.CreateUserRequest;
import com.LetsCodeIt.Secure.Bank.System.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {
    private final UserService userService;

    public Usercontroller(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create-user")
    public ResponseEntity<String>CreateUser(@RequestBody CreateUserRequest createUserRequest){
        userService.saveUser(createUserRequest);
        return ResponseEntity.ok("User created successfully");
    }
}
