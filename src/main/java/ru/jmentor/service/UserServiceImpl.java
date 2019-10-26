package ru.jmentor.service;

import org.springframework.stereotype.Service;
import ru.jmentor.model.Role;
import ru.jmentor.model.User;
import ru.jmentor.repository.UserRepository;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public List<User> getAllUsers(){ return repository.findAll(); }
    @Override
    public void saveUser(User user){
        if(!ExistUserByNameAndPassword(user.getUserName(), user.getUserPassword())){
            user.setRole(Collections.singleton(new Role(1L, "user")));
            repository.save(user);
        }
    }

    private boolean userExistByName(String userName) { return repository.isExistUserByName(userName); }

    @Override
    public User getUserById(Long id){ return repository.findById(id).get(); }
    @Override
    public void deleteUserById(Long id){ repository.deleteById(id); }
    @Override
    public void editUser(User user){ repository.save(user); }
    @Override
    public User getByName(String name) { return repository.getByName(name); }

    public boolean ExistUserByNameAndPassword(String userName, String userPassword){ return repository.isExistUserByNameAndPassword(userName,userPassword); }

}
