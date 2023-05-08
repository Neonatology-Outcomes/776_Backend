package com.neonatal.backend.controllers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.neonatal.backend.entities.Parent_Bundle;
import com.neonatal.backend.entities.User;
import com.neonatal.backend.models.NurseTasks;
import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.RuleObjectPOJO;
import com.neonatal.backend.repositories.ParentBundleRepository;
import com.neonatal.backend.repositories.UserRepository;
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
public class RegistrationController {

    @Autowired
    private JwtUtils jwtUtils;
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Gets all bundle information and returns them as a JSON array of rows with values
     * for: Rule Name, Condition, Action
     * @return an ArrayList of RUleOBjectPOJO that represents the JSON.
     */
    
   // Show Register page.
   @CrossOrigin(origins = "*")
   @RequestMapping(value = "/signup", method = RequestMethod.POST)
   public ResponseEntity<String> viewRegister(@RequestBody User user) {
	   String jwtToken;
	   
	   String DB_username = userRepository.getUsernameByUsername(user.getUsername());
	   String DB_email = userRepository.getEmailByEmail(user.getEmailaddress()) ;
	   
	   //System.out.println(DB_username + DB_email);
	   
	   if( (DB_username != null) && (DB_email != null) )
  
	   {
		   jwtToken = "Username and email address already exists";
		   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(jwtToken);
	   }
	   else if( (DB_username != null) && (DB_email == null) )
		   {
			   jwtToken = "Username already exists";
			   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(jwtToken);
		   }
	   else if( (DB_username == null) && (DB_email != null) )
	   {
		   jwtToken = "Email address already exists";
		   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(jwtToken);
	   }
	   else if( (DB_username == null) && (DB_email == null) )
	   {
	   jwtToken = jwtUtils.encodeJwt(user.getUsername());
	   
	   System.out.println("Adding User to Database Neonatal");
	   userRepository.save(new User(user.getUsername(), user.getPassword(),
			   user.getEmailaddress(), user.getFirstname(), user.getLastname(), user.getRoleid()));
	   long UserId = user.getId();
       System.out.println("User ID: " + UserId);
       
       return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
	   }
	   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("I don't know the error");
   }
    

}
