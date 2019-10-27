package ru.jmentor.DAO;

import java.util.List;

public interface CrudDao<T> {
    <T>T getById(Long id);
    List<T> getAll();
    void delete(Long id);
    void edit(T user);
    void add(T user);
}
