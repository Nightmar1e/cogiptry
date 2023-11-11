package admin_user.controller;

import java.security.Principal;
import java.util.List;

import admin_user.model.Products;
import admin_user.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import admin_user.dto.UserDto;
import admin_user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	private ProductRepository productService;

	@Autowired
	private UserService userService;


	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register";
	}

	@GetMapping("/login")
	public String login(Principal principal) {
		if (principal != null) {
			return "redirect:/v1/dashboard";
		}
		return "login";
	}

	
}
