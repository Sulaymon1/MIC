package ru.info.tech.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.info.tech.models.InsurancePolicy;
import ru.info.tech.models.User;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sulaymon on 05.11.2017.
 */
public class UserTempDaoImpl implements UserTempDao {
    private static final String SQL_INSERT_USER = "INSERT INTO users_temp(name, surname, lastname, age, tel, address, email, username, password,control_phrase) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users_temp WHERE email=?";
    private static final String SELECT_USER_WHERE_USERNAME_AND_PASSWORD = "SELECT * FROM users_temp WHERE control_phrase=:control_phrase" ;

    private JdbcTemplate template;
    private Map<Long, User> userMap;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private UserTempDaoImpl(DataSource dataSource) {
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



    @Override
    public void delete(User model) {
        template.update(con -> {
            PreparedStatement statement =
                    con.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setLong(1, model.getId());
            return statement;
        });
    }

    @Override
    public void delete(String email){
        template.update(con -> {
            PreparedStatement statement =
                    con.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setString(1,email);
            return statement;
        });
    }

    @Override
    public void save(User model, String control_phrase) {
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
                statement.setString(10, control_phrase);
                return statement;
            }, keyHolder);
            model.setId(keyHolder.getKey().longValue());

    }

    public User findUserByControlPhrase(String control_phrase) {
        Map<String, Object> param = new HashMap<>();
        param.put("control_phrase", control_phrase);
        User user;
        try {
            user = namedParameterJdbcTemplate.query(SELECT_USER_WHERE_USERNAME_AND_PASSWORD, param, rowMapper).get(0);
        }catch (IndexOutOfBoundsException e){
            user =null;
        }
        userMap.clear();
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
    @Override
    public void save(User model) {}
    @Override
    public User find(Long id) {
        return null;
    }
    @Override
    public void update(User model) {}
}
