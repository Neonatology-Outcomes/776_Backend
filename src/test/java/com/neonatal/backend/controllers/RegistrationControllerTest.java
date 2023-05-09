package com.neonatal.backend.controllers;

import com.neonatal.backend.entities.User;
import com.neonatal.backend.repositories.UserRepository;
import com.neonatal.backend.services.JwtUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class RegistrationControllerTest {
    @Mock
    public  JwtUtils mockjwtUtils = Mockito.mock(JwtUtils.class);
    @Mock
    public UserRepository mockuserRepository = Mockito.mock(UserRepository.class);
    public RegistrationController registrationControllerUAT;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void viewRegisterHappyPath(){
        /*this test currently does not work.
        Due to the cause of the issue being unknown, this
        will be the only test written for this controller for now.
        */
        //setup
        String mockUsername = "user";
        String mockEmail = "mail@mail.mail";
        User mockUser = new User();
        when(mockuserRepository.getUsernameByUsername(mockUser.getUsername())).thenReturn(mockUsername);
        when(mockuserRepository.getEmailByEmail(mockUser.getEmailaddress())).thenReturn(mockEmail);
        //test
        ResponseEntity<String> results = registrationControllerUAT.viewRegister(mockUser);
        //assert
        ResponseEntity<String> expected = new ResponseEntity<>(HttpStatus.OK);
        assertEquals(expected, results);
    }
}
