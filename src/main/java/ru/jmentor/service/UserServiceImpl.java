package ru.jmentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jmentor.DAO.UserDao;
import ru.jmentor.model.Role;
import ru.jmentor.model.User;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder) { this.passwordEncoder = passwordEncoder; }

    @Autowired
    public void setRepository(UserDao userDaoHibernate) {
        this.userDao = userDaoHibernate;
    }

    @Override
    @Transactional
    public List<User> getAllUsers(){ return userDao.getAll(); }
    @Override
    @Transactional
    public User getUserById(Long id){
        User user = userDao.getById(id);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return user;
    }
    @Override
    @Transactional
    public void deleteUserById(Long id){ userDao.delete(id); }
    @Override
    @Transactional
    public void editUser(User user){
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        user.setRole(Collections.singleton(new Role(1L, "user")));
        userDao.edit(user);
    }
    @Override
    @Transactional
    public void saveUser(User user){
        if(!userExistByName(user.getUserName())){
            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
            user.setRole(Collections.singleton(new Role(1L, "user")));
            userDao.add(user);
        }
    }
    @Transactional
    public boolean userExistByName(String userName) { return userDao.isExistUserByName(userName); }
    @Override
    @Transactional
    public User getByName(String userName) {
        User user = userDao.getByName(userName);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return user;
    }
}
