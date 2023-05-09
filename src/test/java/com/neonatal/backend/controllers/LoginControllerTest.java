package com.neonatal.backend.controllers;

import com.neonatal.backend.entities.User;
import com.neonatal.backend.models.LoginObjectPOJO;
import com.neonatal.backend.repositories.UserRepository;
import com.neonatal.backend.services.JwtUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginControllerTest {

    @Mock
    public JwtUtils mockJwtUtils = Mockito.mock(JwtUtils.class);
    @Mock
    public UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

    public LoginController loginControllerUAT;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginProcessHappyPath(){
        /*this test currently does not work.
        Due to the cause of the issue being unknown, this
        will be the only test written for this controller for now.
        */
        //setup
        loginControllerUAT = new LoginController();
        String mockUsername = "user";
        String mockPassword = "password";
        String mockRoleID = "nurse";
        User mockUser = new User();
        mockUser.setUsername("user");
        when(mockUserRepository.getUsernameByUsername(mockUser.getUsername())).thenReturn(mockUsername);
        when(mockUserRepository.getPasswordByUsername(mockUser.getUsername())).thenReturn(mockPassword);
        when(mockUserRepository.getRoleidByUsername(mockUser.getUsername())).thenReturn(mockRoleID);
        when(mockJwtUtils.encodeJwt(mockUser.getUsername())).thenReturn("this is a real jwt token I prommy <3");

        //test
        ResponseEntity<LoginObjectPOJO> result = loginControllerUAT.loginProcess(mockUser);
        //assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }


}
