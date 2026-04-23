package com.example.EcommerceBackend.repositories;

import com.example.EcommerceBackend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
