package com.example.proyectodbp.Security.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User newUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Actualiza los campos necesarios en el usuario existente
            existingUser.setFirstname(newUser.getFirstname());
            existingUser.setLastname(newUser.getLastname());
            existingUser.setCountry(newUser.getCountry());
            existingUser.setPassword(newUser.getPassword());
            existingUser.setRole(newUser.getRole());
            existingUser.setDni(newUser.getDni());
            existingUser.setRegion(newUser.getRegion());
            existingUser.setProvincia(newUser.getProvincia());
            existingUser.setDistrito(newUser.getDistrito());
            existingUser.setFotoUrl(newUser.getFotoUrl());
            existingUser.setTelefonoNro(newUser.getTelefonoNro());
            existingUser.setCarritoCompra(newUser.getCarritoCompra());

            return userRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteUser(Integer id) {
        User userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
            return true;
        }
        return false;
    }
}
