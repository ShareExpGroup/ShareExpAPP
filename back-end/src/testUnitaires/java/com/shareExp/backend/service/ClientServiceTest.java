package com.shareExp.backend.service;

import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.model.User;
import com.shareExp.backend.repository.ClientRepository;
import com.shareExp.backend.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static com.shareExp.backend.enumeration.Role.CLIENT;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class ClientServiceTest {
    @Mock
    ClientRepository clientRepository;

    @Test
    @DisplayName("should find client by Email")

    void ShouldFindClientByEmail() {
        ClientService clientService = new ClientService(clientRepository);
        ShareExpClient shareExpClient= new ShareExpClient("jihad","dourhnou",new Date(2000, Calendar.NOVEMBER,2),"jihad@gmail.com","test");
        ShareExpClient expectedshareClient= new ShareExpClient("jihad","dourhnou",new Date(2000,Calendar.NOVEMBER,2),"jihad@gmail.com","test");
        Mockito.when(clientRepository.findByEmail("jihad@gmail.com")).thenReturn(Optional.of(shareExpClient));
        User actualUserResponse = clientService.findByEmail("jihad@gmail.com");
        org.assertj.core.api.Assertions.assertThat(actualUserResponse.getEmail()).isEqualTo(expectedshareClient.getEmail());
    }
}




