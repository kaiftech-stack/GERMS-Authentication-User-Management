package com.germs.germs_auth.controller;

import com.germs.germs_auth.entity.User;
import com.germs.germs_auth.service.AuthService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User registerUser(
            @RequestParam @NotBlank String name,
            @RequestParam @Email String email,
            @RequestParam @Size(min = 6) String password,
            @RequestParam @NotNull Long roleId,
            @RequestParam @NotNull Long companyId
    ) {
        return authService.registerUser(name, email, password, roleId, companyId);
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        return authService.login(email, password);
    }

}

