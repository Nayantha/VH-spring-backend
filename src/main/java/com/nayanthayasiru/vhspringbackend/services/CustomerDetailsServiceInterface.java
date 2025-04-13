package com.nayanthayasiru.vhspringbackend.services;

import com.nayanthayasiru.vhspringbackend.models.DTOs.AuthResponseDTO;
import com.nayanthayasiru.vhspringbackend.models.DTOs.RegisterRequestDTO;

public interface CustomerDetailsServiceInterface {
    AuthResponseDTO registerCustomer(RegisterRequestDTO registerRequestDTO);

    boolean existsByUsername(String username);
}
