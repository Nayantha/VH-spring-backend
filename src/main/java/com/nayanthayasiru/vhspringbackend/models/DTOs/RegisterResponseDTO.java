package com.nayanthayasiru.vhspringbackend.models.DTOs;

import com.nayanthayasiru.vhspringbackend.models.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record RegisterResponseDTO(
        @NotBlank UUID id,
        @NotBlank String username,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email
) {
    public static RegisterResponseDTO fromClass(Customer customer) {
        return new RegisterResponseDTO(
                customer.getId(),
                customer.getUsername(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}
