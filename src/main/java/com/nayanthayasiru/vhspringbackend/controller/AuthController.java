package com.nayanthayasiru.vhspringbackend.controller;

import com.nayanthayasiru.vhspringbackend.models.DTOs.AuthResponseDTO;
import com.nayanthayasiru.vhspringbackend.models.DTOs.RegisterRequestDTO;
import com.nayanthayasiru.vhspringbackend.services.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CustomerDetailsService customerDetailsService;


    @PostMapping("/register")
    public ResponseEntity<?> login(@RequestBody RegisterRequestDTO registerRequestDTO) {
        if (customerDetailsService.existsByUsername(registerRequestDTO.username())) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }
        try {
            AuthResponseDTO customerDTO = customerDetailsService.registerCustomer(registerRequestDTO);
            return ResponseEntity
                    .created(URI.create("/customers/" + customerDTO.id()))
                    .body(customerDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

