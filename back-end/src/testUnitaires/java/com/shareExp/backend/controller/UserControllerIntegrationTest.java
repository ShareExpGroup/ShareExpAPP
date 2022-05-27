package com.shareExp.backend.controller;

import com.shareExp.backend.model.User;
import com.shareExp.backend.repository.UserRepository;
import com.shareExp.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static com.shareExp.backend.enumeration.Role.CLIENT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc ;
    @MockBean
    private UserService userService;
    @Mock

    private UserRepository userRepository;
    @Test
    void shouldDeleteUserByEmail() throws Exception {
        UserService userService = new UserService(userRepository);
        User user = new User("jihad","dourhnou",new Date(2000, Calendar.NOVEMBER,2),CLIENT,"jihad@gmail.com","12345");
        User expectedUserDeleted = new User("jihad","dourhnou",new Date(2000, Calendar.NOVEMBER,2),CLIENT,"jihad@gmail.com","12345");
        Mockito.when(userService.deleteUserWithEmail1("jihad@gmail.com")).thenReturn(expectedUserDeleted);
        mockMvc.perform(delete("/delete/ByEmails"))
                .andDo(print())
                .andExpect(status().isOk());
        User actualUserResponse = userService.getUserWithEmail("jihad@gmail.com");
    }
}