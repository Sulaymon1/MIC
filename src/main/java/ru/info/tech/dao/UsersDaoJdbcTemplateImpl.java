package ru.info.tech.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.info.tech.models.User;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sulaymon on 15.10.2017.
 */
public class UsersDaoJdbcTemplateImpl implements UsersDao {

    private static final String SQL_INSERT_USER = "INSERT INTO users(name, surname, lastname, age, tel, address, email, username, password) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_USERS_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String SQL_UPDATE_USER_TEL_OR_ADDRESS = "UPDATE users SET tel=? OR address=? WHERE id=?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";
    private static final String SELECT_FROM_USERS = "SELECT * FROM users";
    private static final String SELECT_USER_WHERE_USERNAME_AND_PASSWORD = "SELECT * FROM users WHERE username=:username" ;
    private JdbcTemplate template;
    private Map<Long, User> userMap;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        userMap = new HashMap<>();
    }

    private RowMapper<User> rowMapper = ((rs, rowNum)-> {
        Long currentId = rs.getLong(1);
        if (userMap.get(currentId) == null)
            userMap.put(currentId, User.builder()
                    .id(rs.getLong(1))
                    .name(rs.getString(2))
                    .surname(rs.getString(3))
                    .lastname(rs.getString(4))
                    .age(rs.getString(5))
                    .tel(rs.getString(6))
                    .address(rs.getString(7))
                    .email(rs.getString(8))
                    .username(rs.getString("username"))
                    .hashPassword(rs.getString("password"))
                    .build());
        return userMap.get(currentId);

    });

    public void save(User model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement statement =
                    con.prepareStatement(SQL_INSERT_USER, new String[] {"id"});
            statement.setString(1, model.getName());
            statement.setString(2, model.getSurname());
            statement.setString(3, model.getLastname());
            statement.setString(4, model.getAge());
            statement.setString(5, model.getTel());
            statement.setString(6, model.getAddress());
            statement.setString(7, model.getEmail());
            statement.setString(8, model.getUsername());
            statement.setString(9, model.getHashPassword());
            return statement;
        }, keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    public User find(Long id) {
        User user = template.query(SQL_SELECT_USERS_BY_ID, new Long[]{id}, rowMapper).get(0);
        userMap.clear();
        return user;
    }

    public void update(User model) {
        template.update(con -> {
            PreparedStatement statement =
                    con.prepareStatement(SQL_UPDATE_USER_TEL_OR_ADDRESS);
            statement.setString(1, model.getTel());
            statement.setString(2, model.getAddress());
            statement.setLong(3, model.getId());
            return statement;
        });
    }

    public void delete(User model) {
        template.update(con -> {
            PreparedStatement statement =
                    con.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setLong(1, model.getId());
            return statement;
        });
    }

    public List<User> findAll() {
        List<User> userList = template.query(SELECT_FROM_USERS, rowMapper);
        userMap.clear();
        return userList;
    }

    public User findByUsernameAndPassword(String username, String password) {
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        User user ;
        try {
            user = namedParameterJdbcTemplate.query(SELECT_USER_WHERE_USERNAME_AND_PASSWORD, param, rowMapper).get(0);
        }catch (IndexOutOfBoundsException e){
            user =null;
        }
        userMap.clear();
        return user;
    }
}
