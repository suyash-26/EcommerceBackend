package com.example.EcommerceBackend.entities;

import com.example.EcommerceBackend.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

//@Entity
//@Getter @Setter
//@Table(name="users")
//public class UserEntity {
//    @Id
//    private long user_id;
//    private String name;
//    private String email;
//    private String password;
//
//}

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // USER, ADMIN

    private boolean isActive = true;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;
}
