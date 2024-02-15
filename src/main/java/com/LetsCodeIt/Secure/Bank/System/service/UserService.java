package com.LetsCodeIt.Secure.Bank.System.service;

import com.LetsCodeIt.Secure.Bank.System.bo.user.CreateUserRequest;
import com.LetsCodeIt.Secure.Bank.System.bo.user.UpdateUserStatusRequest;

import java.util.List;

public interface UserService {

    void saveUser(CreateUserRequest createUserRequest);

    void updateUserStatus(Long userID, UpdateUserStatusRequest updateUserStatusRequest);
    List<String> getAllUsersWithStrongPassword();
}


