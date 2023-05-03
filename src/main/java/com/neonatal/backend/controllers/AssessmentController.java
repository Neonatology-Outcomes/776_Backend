package com.neonatal.backend.controllers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.neonatal.backend.entities.Assessment;
import com.neonatal.backend.models.NurseTasks;
import com.neonatal.backend.repositories.AssessmentRepository;
import com.neonatal.backend.repositories.UserRepository;
import com.neonatal.backend.services.AssessmentService;
import com.neonatal.backend.services.JwtUtils;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;
    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value= "/saveAssessment/" , method= RequestMethod.POST)
    @PostMapping
    public ResponseEntity<String> saveAssessment(@RequestBody Assessment assessment,
                                                 @RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.saveAssessment(assessment), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.saveAssessment(assessment), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }






}
