package com.neonatal.backend.controllers;

<<<<<<< Updated upstream
import com.neonatal.backend.entities.Assessment;
import com.neonatal.backend.entities.User;
import com.neonatal.backend.entities.Role;
import com.neonatal.backend.repositories.AssessmentRepository;
import com.neonatal.backend.services.JwtUtils;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RegistrationController {

	@Autowired
	private User UserRC;
	
	@Autowired
	private UserValidator UserValidator;
	
	@Autowired
   private UserDAO UserDAO;

	
	@Autowired
	private Role RoleRC;
	
	// Set a form validator
   @InitBinder
   protected void initBinder(WebDataBinder dataBinder) {
      // Form target
      Object target = dataBinder.getTarget();
      if (target == null) {
         return;
      }
      System.out.println("Target=" + target);

      if (target.getClass() == User.class) {
         dataBinder.setValidator(UserValidator);
      }
   }

	
	@RequestMapping("/")
	   public String viewHome(Model model) {

	      return "welcomePage";
	   }
	
	@RequestMapping("/registerSuccessful")
	   public String viewRegisterSuccessful(Model model) {

	      return "registerSuccessfulPage";
	   }
	
	 // Show Register page.
	   @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public String viewRegister(@RequestBody User user) {
		   String jwtToken = JwtUtils.encode(user.getUsername());
		   userRepository.save(user);
	      return jwtToken;
	   }

	   // This method is called to save the registration information.
	   // @Validated: To ensure that this Form
	   // has been Validated before this method is invoked.
	   @RequestMapping(value = "/register", method = RequestMethod.POST)
	   public String saveRegister(Model model, //
	         @ModelAttribute("UserForm") 
	   		@Validated User UserForm, //
	         BindingResult result, //
	         final RedirectAttributes redirectAttributes) {
	
	      // Validate result
	      if (result.hasErrors()) {

	         return "registerPage";
	      }
	      User newUser= null;
	      try {
	         newUser = UserDAO.createUser(UserForm);
	      }
	      // Other error!!
	      catch (Exception e) {
	         model.addAttribute("errorMessage", "Error: " + e.getMessage());
	         return "registerPage";
	      }

	      redirectAttributes.addFlashAttribute("flashUser", newUser);
	      
	      return "redirect:/registerSuccessful";
	   }


   
}
=======
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
   @RequestMapping(value = "/signup", method = RequestMethod.POST)
   public String viewRegister(@RequestBody User user) {
	   String jwtToken;
	   
	   jwtToken = jwtUtils.encodeJwt(user.getUsername());
	   
	   System.out.println("Adding User to Database Neonatal");
	   userRepository.save(new User(user.getUsername(), user.getPassword(),
			   user.getEmailaddress(), user.getFirstname(), user.getLastname(), user.getRoleid()));
	   long UserId = user.getId();
       System.out.println("User ID: " + UserId);
	   return jwtToken;
   }

    

}
>>>>>>> Stashed changes
