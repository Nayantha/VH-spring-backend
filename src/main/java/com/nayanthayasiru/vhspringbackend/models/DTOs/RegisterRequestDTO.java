package com.nayanthayasiru.vhspringbackend.models.DTOs;

import com.nayanthayasiru.vhspringbackend.models.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.password.PasswordEncoder;

public record RegisterRequestDTO(
        @NotBlank String password,
        @NotBlank String username,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email
) {
    public static Customer fromDTO(RegisterRequestDTO dto, PasswordEncoder passwordEncoder) {
        Customer customer = new Customer();
        customer.setUsername(dto.username());
        customer.setPassword(passwordEncoder.encode(dto.password()));
        customer.setFirstName(dto.firstName());
        customer.setLastName(dto.lastName());
        customer.setEmail(dto.email());
        return customer;
    }
}
