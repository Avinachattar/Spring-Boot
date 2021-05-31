package com.zensar.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.spring.model.User;
import com.zensar.spring.service.UserService;
import com.zensar.spring.service_impl.EmailServiceClass;
import com.zensar.spring.service_impl.OTPServiceClass;
import com.zensar.spring.utility.EmailTemplate;

@Controller
public class UserController {
	private User user1;
	@Autowired
	private UserService service;

	@Autowired
	public OTPServiceClass otpService;

	@Autowired
	public EmailServiceClass emailService;

	@RequestMapping("/index")
	public String home() {
		return "index";
	}

	@RequestMapping("/homePage")
	public String homePage() {
		return "home";
	}

	@GetMapping("/tregister")
	public String register() {
		return "tregister";

	}

	@RequestMapping(value = "/otp")
	public String sregister(@Valid User user, BindingResult result, Model model, @RequestParam("email") String email)
			throws Exception {
		String errorMessage = "Email Id already Exist";
		String invalidMessage = "Not a valid email Id";
		String name = "Atleast 3 characters are required";
		if (result.hasErrors()) {
			model.addAttribute("fullname", name);
			return "tregister";
		}

		int register = service.register(user);
		user1 = user;
		if (register == 401) {
			model.addAttribute("message", invalidMessage);
			return "tregister";
		}
		if (register == 200) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			int otp = otpService.generateOTP(username);
			EmailTemplate template = new EmailTemplate("sendOtp.jsp");
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("user", username);
			replacements.put("otpnum", String.valueOf(otp));
			String message = template.getTemplate(replacements);
			emailService.sendOtpMessage(email, "OTP Verification", message);
			return "otp";
		}
		if (register == 400) {
			model.addAttribute("errorMessage", errorMessage);
			return "tregister";
		}
		return null;
	}

	@RequestMapping(value = "/validateOtp")
	public String validateOtp(@RequestParam("otpnum") int otpnum) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		if (otpnum >= 0) {
			int serverOtp = otpService.getOtp(username);
			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					otpService.clearOTP(username);
					service.registerForm(user1);
					return "sregister";
				} else {
					return "invalidOtp";
				}
			} else {
				return "invalidOtp";
			}
		} else {
			return "invalidOtp";
		}
	}

	@RequestMapping("/userLogin")
	public String userlogin(@ModelAttribute User user) {
		System.out.println("inside userlogin");
		return "login";

	}

	@RequestMapping(value = "/home")
	public String slogin(@ModelAttribute User user, Model model) {
		int login = service.login(user.getEmail(), user.getPassword());
		System.out.println(login);
		String errorMessage = "Not a registerd Id";
		String wrongPassword = "Password doesn't match";
		if (login == 400) {
			model.addAttribute("errorMessage", errorMessage);
			return "login";
		}
		if (login == 401) {
			model.addAttribute("wrongPassword", wrongPassword);
			return "login";
		}
		if (login == 200) {
			return "home";
		}
		return null;

	}

	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
}
