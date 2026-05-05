package org.example.timeorganiser.services;

import dto.RegistrationRequest;
import dto.UsersDTO;
import jakarta.persistence.EntityNotFoundException;
import org.example.timeorganiser.model.Users;
import org.example.timeorganiser.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordencoder,  ModelMapper modelMapper)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordencoder;
        this.modelMapper = modelMapper;
    }

    public void registerUser(RegistrationRequest dto)
    {
        Users user = new Users();
        user.setUsersname(dto.getUsername());
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        userRepository.save(user);
    }

    public Users getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    public void deleteUser(Integer id){
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

    public Users updateProfile(Integer id, UsersDTO updateDto) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(updateDto, user);

        return userRepository.save(user);
    }
}
