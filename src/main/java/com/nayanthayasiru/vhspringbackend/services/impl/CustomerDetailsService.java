package com.nayanthayasiru.vhspringbackend.services.impl;

import com.nayanthayasiru.vhspringbackend.models.Customer;
import com.nayanthayasiru.vhspringbackend.models.DTOs.AuthResponseDTO;
import com.nayanthayasiru.vhspringbackend.models.DTOs.RegisterRequestDTO;
import com.nayanthayasiru.vhspringbackend.repositories.CustomerRepository;
import com.nayanthayasiru.vhspringbackend.services.CustomerDetailsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService, CustomerDetailsServiceInterface {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User name not found."));
    }

    @Override
    public AuthResponseDTO registerCustomer(RegisterRequestDTO registerRequestDTO) {
        Customer newCustomer = RegisterRequestDTO.fromDTO(registerRequestDTO, passwordEncoder);

        Customer savedCustomer = customerRepository.save(newCustomer);

        return AuthResponseDTO.fromClass(savedCustomer);
    }

    @Override
    public boolean existsByUsername(String username) {
        return customerRepository.existsByUsername(username);
    }
}
