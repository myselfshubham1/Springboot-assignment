package io.github.myselfshubham1.spring_boot_assignment.user.services;

import io.github.myselfshubham1.spring_boot_assignment.user.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User updatedUser);
    boolean deleteUser(Long id);
}
