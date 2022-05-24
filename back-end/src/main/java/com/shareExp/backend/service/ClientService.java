package com.shareExp.backend.service;

import com.shareExp.backend.exception.UserNotFoundException;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.ClientRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService extends UserService<ShareExpClient>{

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }
 public ShareExpClient findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    public ShareExpClient findCurrentClient() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<ShareExpClient> coach = clientRepository.findByEmail(email);
        if (coach.isPresent())
            return coach.get();
        throw new UserNotFoundException(email);
    }
}