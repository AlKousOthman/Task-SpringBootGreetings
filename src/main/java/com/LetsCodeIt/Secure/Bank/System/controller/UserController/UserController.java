package com.LetsCodeIt.Secure.Bank.System.controller.UserController;

import com.LetsCodeIt.Secure.Bank.System.bo.user.CreateUserRequest;
import com.LetsCodeIt.Secure.Bank.System.bo.user.UpdateUserStatusRequest;
import com.LetsCodeIt.Secure.Bank.System.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest){
        try {
            userService.saveUser(createUserRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("User Created successfully");
    }

    @PutMapping("/update-user-status")
    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UpdateUserStatusRequest updateUserStatusRequest){
        try{
            userService.updateUserStatus(userId, updateUserStatusRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User Updated successfully");

    }
}
