package com.neonatal.backend.controllers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.neonatal.backend.entities.Assessment;
import com.neonatal.backend.entities.Birth_Details;
import com.neonatal.backend.models.NurseTasks;
import com.neonatal.backend.models.RecoInputPOJO;
import com.neonatal.backend.repositories.AssessmentRepository;
import com.neonatal.backend.repositories.UserRepository;
import com.neonatal.backend.services.AssessmentService;
import com.neonatal.backend.services.JwtUtils;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;
    @Autowired
    private JwtUtils jwtUtils;
    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/saveAssessment")
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
    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/getAllCompliance")
    @GetMapping
    public ResponseEntity<?> getAllCompliance(@RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.getCompliance(), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getCompliance(), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/getComplianceByUhid")
    @GetMapping
    public ResponseEntity<?> getComplianceByUhid(@RequestBody Birth_Details birthDetails, @RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.getComplianceByUhid(birthDetails.getUhid()), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getComplianceByUhid(birthDetails.getUhid()), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/getComplianceByDate")
    @GetMapping
    public ResponseEntity<?> getComplianceByDate(@RequestBody String yearDay, @RequestHeader("Authorization") String authorization){

        try {
            String[] date = yearDay.split(" ");
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.getComplianceByDate(Integer.parseInt(date[0]), Integer.parseInt(date[1])), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getComplianceByDate(Integer.parseInt(date[0]), Integer.parseInt(date[1])), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/getComplianceByDateAndUhid")
    @GetMapping
    public ResponseEntity<?> getComplianceByDateAndUhid(@RequestBody Birth_Details birthDetails, String yearDay, @RequestHeader("Authorization") String authorization){

        try {
            String[] date = yearDay.split(" ");
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.getComplianceByDateAndUhid(birthDetails.getUhid(), Integer.parseInt(date[0]), Integer.parseInt(date[1])), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getComplianceByDateAndUhid(birthDetails.getUhid(), Integer.parseInt(date[0]), Integer.parseInt(date[1])), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }



    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/getRecommendation")
    @GetMapping
    public ResponseEntity<?> getRecommendation(@RequestBody RecoInputPOJO babyDetails,
                                               @RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.getRecommendation(babyDetails), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getRecommendation(babyDetails), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }


}
