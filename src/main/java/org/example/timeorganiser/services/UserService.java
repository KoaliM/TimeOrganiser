package org.example.timeorganiser.services;

import dto.RegistrationRequest;
import org.example.timeorganiser.model.Users;
import org.example.timeorganiser.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordencoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordencoder;
    }

    public void registerUser(RegistrationRequest dto)
    {
        Users user = new Users();
        user.setUsersname(dto.getUsername());
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        userRepository.save(user);
    }
}
