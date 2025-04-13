package com.nayanthayasiru.vhspringbackend.models.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AuthResponseDTO(
        @NotBlank UUID id,
        @NotBlank String username,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email
        ) {}
