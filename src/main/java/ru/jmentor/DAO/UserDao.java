package ru.jmentor.DAO;

import ru.jmentor.model.User;

public interface UserDao extends CrudDao<User> {
    boolean isExistUserByNameAndPassword(String userName, String userPassword);
    boolean isExistUserByName(String userName);
    User getByName(String userName);
}
