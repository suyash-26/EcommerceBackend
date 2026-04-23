package com.example.EcommerceBackend.controllers;

import com.example.EcommerceBackend.dto.user.UpdateUserRequest;
import com.example.EcommerceBackend.dto.user.UserRequest;
import com.example.EcommerceBackend.dto.user.UserResponse;
import com.example.EcommerceBackend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    final private UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserResponse addUser(@RequestBody UserRequest user){
        return userService.addUser(user);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){
        List<UserResponse> res = userService.getAllUsers();
        return ResponseEntity.ok(res);
    }
    @PatchMapping("/updateUser")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest user){
        return ResponseEntity.ok(userService.updateUser(user));
    }
}
