package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Company;
import com.germs.germs_auth.entity.Role;
import com.germs.germs_auth.entity.User;
import com.germs.germs_auth.repository.CompanyRepository;
import com.germs.germs_auth.repository.RoleRepository;
import com.germs.germs_auth.repository.UserRepository;
import com.germs.germs_auth.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CompanyRepository companyRepository;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.companyRepository = companyRepository;
    }

    // ================= REGISTER =================
    public User registerUser(String name,
                             String email,
                             String password,
                             Long roleId,
                             Long companyId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // plain for now
        user.setRole(role);
        user.setCompany(company);

        return userRepository.save(user);
    }

    // ================= LOGIN =================
    public String login(String email, String password) {

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }

        // JWT token generation
        return JwtUtil.generateToken(user.getEmail());
    }
}
