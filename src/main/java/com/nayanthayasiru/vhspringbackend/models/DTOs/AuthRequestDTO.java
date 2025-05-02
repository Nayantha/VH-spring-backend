package com.nayanthayasiru.vhspringbackend.models.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthRequestDTO(
        @NotBlank String password,
        @Email String email,
        String username
) {
}
