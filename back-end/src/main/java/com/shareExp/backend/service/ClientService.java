package com.shareExp.backend.service;

import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

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
}