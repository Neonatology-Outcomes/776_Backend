package com.neonatal.backend.controllers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.neonatal.backend.models.NurseTasks;
import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.RuleObjectPOJO;
import com.neonatal.backend.services.JwtUtils;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines what GET, POST calls related to the Rules and Actions tables
 */

@RestController
public class RulesController {

    @Autowired
    private RulesService rulesService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Gets all bundle information and returns them as a JSON array of rows with values
     * for: Rule Name, Condition, Action
     * @return an ArrayList of RUleOBjectPOJO that represents the JSON.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/getBundles")
    @GetMapping
    public ResponseEntity<?> getBundle(@RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(rulesService.getAll(), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(rulesService.getAll(), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Saves the bundle passed as a JSON to the /saveBundle address into the database
     * @param parentBundle ParentBundlePOJO object representing the JSON that is passed
     * @return A string "success" if successful // TODO: Change this?
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/saveBundle" , method= RequestMethod.POST)
    @PostMapping
    public ResponseEntity<String> saveBundle(@RequestBody ParentBundlePOJO parentBundle,
                                             @RequestHeader("Authorization") String authorization){
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(rulesService.addRules(parentBundle), HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(rulesService.addRules(parentBundle), HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/getJWT")
    @GetMapping
    public ResponseEntity<String> getJWT() {
        System.out.println("JWT generated.");
        return new ResponseEntity<>(jwtUtils.encodeJwt("brandt"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/checkJWT")
    @GetMapping
    public ResponseEntity<?> checkJWT(@RequestHeader("Authorization") String authorization) {
        try {
            int roleID = jwtUtils.checkAuthorization(authorization);
            if (roleID == 1){
                // USER IS A NURSE
                return new ResponseEntity<>(roleID, HttpStatus.OK);
            } else if (roleID == 2) {
                // USER IS AN ADMIN
                return new ResponseEntity<>(roleID, HttpStatus.OK);
            } else {
                // USER DOES NOT EXIST
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (TokenExpiredException tee) {
            return new ResponseEntity("TOKEN EXPIRED", HttpStatus.BAD_REQUEST);
        }

    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getNurseDailyTasks/", method = RequestMethod.GET)
	public List<NurseTasks> getNurseTasks() {
		List<NurseTasks> nurseTasksList = null;
		try {
			nurseTasksList = rulesService.getNurseTasks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nurseTasksList;
	}
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getDashboard/", method = RequestMethod.GET)
	public List<NurseTasks> getDashboard() {
		List<NurseTasks> dashboardList = null;
		try {
			dashboardList = rulesService.getDashboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dashboardList;
	}

}
