package com.nayanthayasiru.vhspringbackend.repositories;

import com.nayanthayasiru.vhspringbackend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByUsername(String username);
    boolean existsByUsername(String username);
}