package org.example.repositories;

import org.example.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAllUser();
    User createUser(User user);
    User findUserByEmail(String emailInput);
    User findUserById(String idInput);
    User updateUser(User update);
    void deleteUser(String emailUser);
}
