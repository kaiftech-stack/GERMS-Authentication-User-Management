package com.germs.germs_auth.service;

import com.germs.germs_auth.entity.Company;
import com.germs.germs_auth.entity.Role;
import com.germs.germs_auth.entity.User;
import com.germs.germs_auth.repository.CompanyRepository;
import com.germs.germs_auth.repository.RoleRepository;
import com.germs.germs_auth.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        user.setPassword(password); // plain for now (encryption later)
        user.setRole(role);
        user.setCompany(company);

        return userRepository.save(user);
    }
}

