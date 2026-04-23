package com.example.EcommerceBackend.services;

import com.example.EcommerceBackend.dto.user.UpdateUserRequest;
import com.example.EcommerceBackend.dto.user.UserRequest;
import com.example.EcommerceBackend.dto.user.UserResponse;
import com.example.EcommerceBackend.entities.User;
import com.example.EcommerceBackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    final private UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserResponse addUser(UserRequest user){
        User userData = new User();
        userData.setEmail(user.getEmail());
        userData.setName(user.getName());
        User savedUser = userRepository.save(userData);
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        return response;
    }
    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserResponse> usersResponse = new ArrayList<>();
        usersResponse = users.stream()
                .map(user -> {
                    UserResponse res = new UserResponse();
                    res.setId(user.getId());
                    res.setEmail(user.getEmail());
                    res.setName(user.getName());
                    return res;
                })
                .toList();
        return usersResponse;
    }
    public UserResponse updateUser(UpdateUserRequest request) {

        if (request.getId() == null) {
            throw new IllegalArgumentException("User Id is required");
        }

        User existingUser = userRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Partial update
        existingUser.setId(request.getId());

        if (request.getName() != null) {
            existingUser.setName(request.getName());
        }

        if (request.getEmail() != null) {
            existingUser.setEmail(request.getEmail());
        }

        User savedUser = userRepository.save(existingUser);
        UserResponse response = new UserResponse();
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return response;
    }
}
