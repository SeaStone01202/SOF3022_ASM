package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.RegisterDto;
import com.springboot.asm.fpoly_asm_springboot.entity.AppUser;
import com.springboot.asm.fpoly_asm_springboot.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new AppUser());
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String email, @RequestParam String password, BindingResult bindingResult) {
        AppUser user = userRepository.findByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            bindingResult.addError(new FieldError("user", "email", "Invalid email or password"));
            model.addAttribute("user", new AppUser());
            return "login";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute RegisterDto registerDto, BindingResult result) {
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(new FieldError("registerDto", "confirmPassword", "Passwords do not match"));
        }

        AppUser appUser = userRepository.findByEmail(registerDto.getEmail());
        if (appUser != null) {
            result.addError(new FieldError("registerDto", "email", "Email is already in use"));
        }

        if (result.hasErrors()) {
            return "register";
        }

        // create new account
        try {
            AppUser newUser = new AppUser();
            newUser.setEmail(registerDto.getEmail());
            newUser.setPhone(registerDto.getPhone());
            newUser.setRole(false);
            newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            userRepository.save(newUser);

            model.addAttribute("success", "Account created successfully! Please log in");
        } catch (Exception e) {
            result.addError(new FieldError("registerDto", "firstName", e.getMessage()));
            return "register";
        }
        return "redirect:/account/login";
    }
}
