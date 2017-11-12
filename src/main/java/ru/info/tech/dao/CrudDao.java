package ru.info.tech.dao;

import java.util.List;

/**
 * Created by Sulaymon on 15.10.2017.
 */
public interface CrudDao<T, I> {
    // create, read, update, delete, readAll
    void save(T model);
    T find(I id);
    void update(T model);
    void delete(T model);
    List<T> findAll();
}
