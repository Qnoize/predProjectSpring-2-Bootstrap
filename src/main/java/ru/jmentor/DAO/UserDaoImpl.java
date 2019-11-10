package ru.jmentor.DAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.jmentor.model.User;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //language=SQL
    private final String SQL_SELECT_BY_ID = "FROM User WHERE id = :id";
    //language=SQL
    private final String SQL_SELECT_BY_NAME = "FROM User WHERE userName = :userName";
    //language=SQL
    private final String SQL_SELECT_BY_NAME_AND_PASS = "FROM User WHERE userName = :userName and userPassword =:userPassword";
    //language=SQL
    private final String SQL_SELECT_ALL = "FROM User AS user LEFT JOIN FETCH user.role";

    @Transactional
    @Override
    public User getById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.createQuery(SQL_SELECT_BY_ID, User.class)
                .setParameter("id", id)
                .uniqueResult();
        Hibernate.initialize(user.getRole());
        session.close();
        return user;
    }

    @Transactional
    @Override
    public boolean isExistUserByNameAndPassword(String userName, String userPassword) {
        Session session = sessionFactory.openSession();
        try {
            User user = session.createQuery(SQL_SELECT_BY_NAME_AND_PASS, User.class)
                    .setParameter("userName", userName)
                    .setParameter("userPassword", userPassword)
                    .uniqueResult();
            if(user != null){ return true; } else {return false;}
        } catch (Exception e){
            System.out.println("Ошибка верификации по логину и паролю");
            e.getStackTrace();
        } finally { if (session.isOpen()) { session.close(); } }
        return false;
    }

    @Transactional
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        List<User> list = new ArrayList<>();
        try {
            session.beginTransaction();
            list = new ArrayList<>(session.createQuery(SQL_SELECT_ALL).list());
            list.sort(Comparator.comparingLong(User::getId));
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Ошибка получения всех пользователей");
            session.getTransaction().rollback();
        } finally { if (session.isOpen()) { session.close(); } }
        return list;
    }
    @Transactional
    public void edit(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Ошибка редактирования пользователя");
            session.getTransaction().rollback();
        } finally { if (session.isOpen()) { session.close(); } }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Ошибка удаения пользователя");
            session.getTransaction().rollback();
        } finally { if (session.isOpen()) { session.close(); } }
    }

    @Transactional
    public void add(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Ошибка добавления пользователя");
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally { if (session.isOpen()) { session.close(); } }
    }

    @Transactional
    @Override
    public boolean isExistUserByName(String userName) {
        Session session = sessionFactory.openSession();
        try {
            User user = session.createQuery(SQL_SELECT_BY_NAME, User.class)
                    .setParameter("userName", userName)
                    .uniqueResult();
            if(user != null){ return true; }
        } catch (Exception e){
            System.out.println("Ошибка нахождения по имени пользователя (isExistUserByName)");
            e.getStackTrace();
        } finally { if (session.isOpen()) { session.close(); } }
        return false;
    }

    @Transactional
    @Override
    public User getByName(String userName) {
        Session session = sessionFactory.openSession();
        User user = null;
        try {
            user = session.createQuery(SQL_SELECT_BY_NAME, User.class)
                    .setParameter("userName", userName)
                    .uniqueResult();
            Hibernate.initialize(user.getRole());
            if(user != null){ return user; }
        } catch (Exception e){
            System.out.println("Ошибка нахождения по имени пользователя (getByName)");
            e.getStackTrace();
        } finally { if (session.isOpen()) { session.close(); } }
        return user;
    }
}
