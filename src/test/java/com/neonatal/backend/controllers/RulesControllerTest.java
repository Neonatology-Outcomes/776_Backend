package com.neonatal.backend.controllers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.neonatal.backend.models.NurseTasks;
import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.RuleObjectPOJO;
import com.neonatal.backend.services.JwtUtils;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RulesControllerTest {
    @Mock
    public RulesService mockrulesService = Mockito.mock(RulesService.class);
    @Mock
    public JwtUtils mockjwtUtils = Mockito.mock(JwtUtils.class);

    public RulesController rulesControllerUAT;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getBundleHappyPath(){
        /*this test currently does not work.
        Due to the cause of the issue being unknown, this
        will be the only test written for this controller for now.
        */
        //setup
        rulesControllerUAT = new RulesController();
        String mockAuthorization = "all clear";
        RuleObjectPOJO mockRuleObjectPojo = new RuleObjectPOJO(
                "ruleName",
                "condition",
                "action");
        ArrayList<RuleObjectPOJO> mockRuleObjectPojoList = new ArrayList<RuleObjectPOJO>();
        mockRuleObjectPojoList.add(mockRuleObjectPojo);
        when(mockjwtUtils.checkAuthorization(mockAuthorization)).thenReturn(1);
        when(mockrulesService.getAll()).thenReturn(mockRuleObjectPojoList);
        //test
        ResponseEntity<?> results = rulesControllerUAT.getBundle(mockAuthorization);
        //assert
        ResponseEntity<?> expected = new ResponseEntity<>(HttpStatus.OK);
        assertEquals(expected, results);
    }

}
