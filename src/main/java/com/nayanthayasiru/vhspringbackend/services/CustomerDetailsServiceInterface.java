package com.nayanthayasiru.vhspringbackend.services;

import com.nayanthayasiru.vhspringbackend.models.DTOs.RegisterRequestDTO;
import com.nayanthayasiru.vhspringbackend.models.DTOs.RegisterResponseDTO;

public interface CustomerDetailsServiceInterface {
    RegisterResponseDTO registerCustomer(RegisterRequestDTO registerRequestDTO);

    boolean existsByUsername(String username);
}
