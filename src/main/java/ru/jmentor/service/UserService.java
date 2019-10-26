package ru.jmentor.service;

import ru.jmentor.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    void editUser(User user);
    User getByName(String name);
}
