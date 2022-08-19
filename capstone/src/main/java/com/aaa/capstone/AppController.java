package com.aaa.capstone;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aaa.capstone.enity.user;
import com.aaa.capstone.repository.UserRepository;


//@SuppressWarnings("unused")
@Controller
public class AppController {

@Autowired
private UserRepository userRepo;
    
   @GetMapping("")
   public String viewHomePage() {
       return "index";
   }

   @GetMapping("/register")
   public String showRegistrationForm(Model model) {
	   @SuppressWarnings("unused")
	User user = new User();
	 model.addAttribute("user", new User());
     
    return "signup_form";
}

public UserRepository getUserRepo() {
	return userRepo;
}

public void setUserRepo(UserRepository userRepo) {
	this.userRepo = userRepo;
}

@PostMapping("/process_register")
public String processRegister(@ModelAttribute user User, Model model) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(User.getPassword());
    User.setPassword(encodedPassword);
    model.addAttribute("user", User);
	user savedUser = userRepo.save(User);
   // userRepo.save(User);
     
    return "register_success";
}
@GetMapping("/users")
public String listUsers(Model model) {
    List<user> listUsers = userRepo.findAll();
    model.addAttribute("listUsers", listUsers);
     
    return "users";
}

}
