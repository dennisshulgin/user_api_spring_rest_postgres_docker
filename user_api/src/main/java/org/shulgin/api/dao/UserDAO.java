package org.shulgin.api.dao;

import org.shulgin.api.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void deleteUser(int id);
}
