package com.neonatal.backend.controllers;

import com.neonatal.backend.entities.Assessment;
import com.neonatal.backend.entities.User;
import com.neonatal.backend.entities.Role;
import com.neonatal.backend.repositories.AssessmentRepository;
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
	   public String viewRegister(Model model) {

	      return "registerPage";
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