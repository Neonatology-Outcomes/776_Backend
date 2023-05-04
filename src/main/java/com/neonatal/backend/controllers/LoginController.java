package com.neonatal.backend.controllers;

import com.neonatal.backend.entities.User;
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
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void loginProcess(@RequestBody User user)
    {  
    	String DB_username = userRepository.getUsernameByUsername(user.getUsername());
    	String DB_password = userRepository.getPasswordByUsername(user.getUsername());
    	//System.out.println(DB_username + DB_password);

      if (DB_username != null)   
      {
    	  String Arg_Password = user.getPassword();
    	  
    	  if(DB_password.matches(Arg_Password))
    	  {
    		  System.out.println("Inside Password");
        	  jwtToken = jwtUtils.encodeJwt(user.getUsername());
        	  returnTokenLogin(jwtToken);
    	  }
    	  else
    	  {
    		  jwtToken = "Wrong Password Entered";
    		  withResponseEntityLogin(jwtToken);
    	  }

      }
      else 
      {
    	  jwtToken = "User does not exist";
    	  withResponseEntityLogin(jwtToken);
      }
    }
    
    @GetMapping("/response_entity_login")
    public ResponseEntity<String> withResponseEntityLogin(String exception_reason) {
         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(exception_reason);   
    }   
    
    @GetMapping("/return_token_login")
    public String returnTokenLogin(String token_value) {
         return token_value;   
    }
    
    @RequestMapping(value = "/forget_password", method = RequestMethod.POST)
    public void forgetpassword(@RequestBody User user)
    {  
    	String DB_password = userRepository.getPasswordByEmail(user.getEmailaddress());

      if (DB_password != null)   
      {
    		  System.out.println("Inside Password");
        	  jwtToken = DB_password;
        	  returnTokenLogin(jwtToken);

      }
      else 
      {
    	  jwtToken = "User does not exist";
    	  withResponseEntityLogin(jwtToken);
      }
    }


}
