package com.shareExp.backend.service;

import com.shareExp.backend.DTO.ExpRequestDto;
import com.shareExp.backend.DTO.ShareExpClientDto;
import com.shareExp.backend.DTO.ShareExpClientDto1;
import com.shareExp.backend.exception.UserNotFoundException;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.ClientRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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




    public List<ShareExpClientDto1> getAllOClients() {
        List<ShareExpClient> clients =  clientRepository.findAll();
        return clients.stream().map(ShareExpClientDto1::new).collect(Collectors.toList());
    }




}