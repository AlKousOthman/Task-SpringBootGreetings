package com.LetsCodeIt.Secure.Bank.System.service;

import com.LetsCodeIt.Secure.Bank.System.Util.enums.Status;
import com.LetsCodeIt.Secure.Bank.System.bo.user.CreateUserRequest;
import com.LetsCodeIt.Secure.Bank.System.bo.user.UpdateUserStatusRequest;
import com.LetsCodeIt.Secure.Bank.System.entity.UserEntity;
import com.LetsCodeIt.Secure.Bank.System.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity= new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);
    }

    @Override
    public void updateUserStatus(Long userID, UpdateUserStatusRequest updateUserStatusRequest) {
        UserEntity userEntity=userRepository.findById(userID)
                .orElseThrow();
        if(!updateUserStatusRequest.getStatus().equals("ACTIVE") && !updateUserStatusRequest.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("The status should be ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserStatusRequest.getStatus()));
        userRepository.save(userEntity);
    }
    @Override
    public List<String> getAllUsersWithStrongPassword() {
        return userRepository.findAll()
                .stream()
                .filter(e -> e.getPassword().length() > 8)
                .map(UserEntity::getName)
                .collect(Collectors.toList());
    }
}