package ru.jmentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jmentor.DAO.UserDao;
import ru.jmentor.model.Role;
import ru.jmentor.model.User;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDaoHibernate;

    @Autowired
    public void setRepository(UserDao userDaoHibernate) {
        this.userDaoHibernate = userDaoHibernate;
    }

    @Override
    @Transactional
    public List<User> getAllUsers(){ return userDaoHibernate.getAll(); }
    @Override
    @Transactional
    public User getUserById(Long id){ return userDaoHibernate.getById(id); }
    @Override
    @Transactional
    public void deleteUserById(Long id){ userDaoHibernate.delete(id); }
    @Override
    @Transactional
    public void editUser(User user){
        user.setRole(Collections.singleton(new Role(1L, "user")));
        userDaoHibernate.edit(user);
    }
    @Override
    @Transactional
    public void saveUser(User user){
        if(!userExistByName(user.getUserName())){
            user.setRole(Collections.singleton(new Role(1L, "user")));
            userDaoHibernate.add(user);
        }
    }
    @Transactional
    public boolean userExistByName(String userName) { return userDaoHibernate.isExistUserByName(userName); }
    @Override
    @Transactional
    public User getByName(String userName) { return userDaoHibernate.getByName(userName); }
    @Override
    @Transactional
    public boolean ExistUserByNameAndPassword(String userName, String userPassword){
        return userDaoHibernate.isExistUserByNameAndPassword(userName,userPassword);
    }
}
