package com.neonatal.backend.controllers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.neonatal.backend.entities.Assessment;
import com.neonatal.backend.entities.Birth_Details;
import com.neonatal.backend.models.BirthDateDetailsPOJO;
import com.neonatal.backend.models.RecoInputPOJO;
import com.neonatal.backend.services.AssessmentService;
import com.neonatal.backend.services.JwtUtils;
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
                return new ResponseEntity<>(assessmentService.getAllCompliance(), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getAllCompliance(), HttpStatus.OK);
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
    public ResponseEntity<?> getComplianceByDate(@RequestBody BirthDateDetailsPOJO birthDetailsAndDate, @RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.getComplianceByDate(birthDetailsAndDate.getYear(), birthDetailsAndDate.getMonth(), birthDetailsAndDate.getDay()), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getComplianceByDate(birthDetailsAndDate.getYear(), birthDetailsAndDate.getMonth(), birthDetailsAndDate.getDay()), HttpStatus.OK);
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
    public ResponseEntity<?> getComplianceByDateAndUhid(@RequestBody BirthDateDetailsPOJO birthDetailsAndDate, @RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(assessmentService.getComplianceByDateAndUhid(birthDetailsAndDate.getUhid(), birthDetailsAndDate.getYear(), birthDetailsAndDate.getMonth(), birthDetailsAndDate.getDay()), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(assessmentService.getComplianceByDateAndUhid(birthDetailsAndDate.getUhid(), birthDetailsAndDate.getYear(), birthDetailsAndDate.getMonth(), birthDetailsAndDate.getDay()), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }

}
