package com.shareExp.backend.controller;

import com.shareExp.backend.DTO.ShareExpClientDto1;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/superuser")
public class AdminController {
    ClientService clientService;

    public AdminController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/listNotVerified")
    public ResponseEntity<List<ShareExpClientDto1>>
    listNotVerified() {
        return new ResponseEntity<>(
                clientService.getAllOClients(),
                HttpStatus.OK
        );
    }

    @GetMapping("/now")
    public ResponseEntity<List<ShareExpClient>> listAllClients(){
        return new ResponseEntity<>(
                clientService.getAllUsers(),
                HttpStatus.OK
        );
    }
}
