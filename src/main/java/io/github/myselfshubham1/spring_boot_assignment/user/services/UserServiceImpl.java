package io.github.myselfshubham1.spring_boot_assignment.user.services;

import io.github.myselfshubham1.spring_boot_assignment.user.model.User;
import io.github.myselfshubham1.spring_boot_assignment.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * implementation of user service
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * full body function to create user
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * full body function to get user by id
     */
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * full body function to get all user
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * full body function to update user
     */
    @Override
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }

    /**
     * full body function to delete user
     */
    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
