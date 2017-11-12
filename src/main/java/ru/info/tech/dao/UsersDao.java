package ru.info.tech.dao;

import ru.info.tech.models.User;

/**
 * Created by Sulaymon on 15.10.2017.
 */
public interface UsersDao  extends  CrudDao<User, Long>{
    User findByUsernameAndPassword(String username, String password);
}
