package com.neonatal.backend.controllers;

import com.neonatal.backend.entities.User;
import com.neonatal.backend.models.LoginObjectPOJO;
import com.neonatal.backend.repositories.UserRepository;
import com.neonatal.backend.services.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class that defines what GET, POST calls related to the Rules and Actions tables
 */

@RestController
public class LoginController {

    @Autowired
    private JwtUtils jwtUtils;
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Gets all bundle information and returns them as a JSON array of rows with values
     * for: Rule Name, Condition, Action
     * @return an ArrayList of RUleOBjectPOJO that represents the JSON.
     */
    
   // Show Register page
//    @Autowired
//    User user;
    
    String jwtToken;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginObjectPOJO> loginProcess(@RequestBody User user)
    {  
    	String DB_username = userRepository.getUsernameByUsername(user.getUsername());
    	String DB_password = userRepository.getPasswordByUsername(user.getUsername());
    	String DB_roleid = userRepository.getRoleidByUsername(user.getUsername());
    	
    	LoginObjectPOJO l_obj;
    	
      if (DB_username != null)   
      {
    	  String Arg_Password = user.getPassword();
    	  
    	  if(DB_password.matches(Arg_Password))
    	  {
        	  jwtToken = jwtUtils.encodeJwt(user.getUsername());
        	  l_obj = new LoginObjectPOJO(jwtToken, DB_roleid);
        	  return ResponseEntity.status(HttpStatus.OK).body(l_obj);
    	  }
    	  else
    	  {
    		  jwtToken = "Wrong Password Entered";
    		  l_obj = new LoginObjectPOJO(jwtToken, null);
    		  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(l_obj);
    	  }

      }
      else 
      {
    	  jwtToken = "User does not exist";
    	  l_obj = new LoginObjectPOJO(jwtToken, null);
    	  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(l_obj);
      }
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/forget_password", method = RequestMethod.POST)
    public ResponseEntity<String> forgetpassword(@RequestBody User user)
    {  
    	String DB_password = userRepository.getPasswordByEmail(user.getEmailaddress());

      if (DB_password != null)   
      {
        	  jwtToken = DB_password;
        	  return ResponseEntity.status(HttpStatus.OK).body(jwtToken);

      }
      else 
      {
    	  jwtToken = "User does not exist";
    	  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(jwtToken);
      }
    }


}
