package ru.jmentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.jmentor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.userName = :userName")
    User getByName(@Param("userName") String userName);

    @Query("FROM User WHERE userName =: userName and userPassword =: userPassword")
    boolean isExistUserByNameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    @Query("FROM User WHERE userName =: userName")
    boolean isExistUserByName(@Param("userName") String userName);
}
