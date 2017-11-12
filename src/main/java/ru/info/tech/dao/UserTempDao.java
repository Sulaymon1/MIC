package ru.info.tech.dao;

import ru.info.tech.models.User;

/**
 * Created by Sulaymon on 05.11.2017.
 */
public interface UserTempDao extends CrudDao<User, Long> {
    void delete(String email);
    void save(User user, String s);
    User findUserByControlPhrase(String control_phrase);
}
