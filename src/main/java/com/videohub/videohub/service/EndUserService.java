package com.videohub.videohub.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videohub.videohub.model.EndUser;
import com.videohub.videohub.repository.EndUserRepository;

import java.util.List;

@Service
public class EndUserService {

    private final EndUserRepository userRepository;

    @Autowired
    public EndUserService(EndUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<EndUser> getAllUsers() {
        return userRepository.findAll();
    }

    public EndUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public EndUser createUser(EndUser user) {
        return userRepository.save(user);
    }

    public EndUser updateUser(Long id, EndUser user) {
        EndUser existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
            existingUser.setMail(user.getMail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        EndUser existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
    }
}
