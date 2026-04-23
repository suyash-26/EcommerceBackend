package com.example.EcommerceBackend.dto.user;

import com.example.EcommerceBackend.entities.Address;
import com.example.EcommerceBackend.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
}
