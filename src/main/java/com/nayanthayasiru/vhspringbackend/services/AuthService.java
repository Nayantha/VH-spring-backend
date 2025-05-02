package com.nayanthayasiru.vhspringbackend.services;

import com.nayanthayasiru.vhspringbackend.models.DTOs.AuthRequestDTO;
import com.nayanthayasiru.vhspringbackend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    public String authenticate(AuthRequestDTO authRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.username(), authRequestDTO.password())
        );
        return jwtUtil.generateToken(authRequestDTO.username());
    }
}
