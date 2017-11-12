package ru.info.tech.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.info.tech.models.InsurancePolicy;
import ru.info.tech.models.User;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sulaymon on 21.10.2017.
 */
public class InsuranceDaoImpl implements InsuranceDao {

    public static final String INSERT_INSURANCE_FOR_ONE = "INSERT INTO insurance_for_one(id, passport_series, price, expiration_date) VALUES (?,?,?,?)";
    public static final String SELECT_INSURANCE_FOR_ONE_BY_ID = "SELECT * FROM insurance_for_one WHERE id=?";
    private JdbcTemplate template;
    private Map<Long, InsurancePolicy> map;

    private InsuranceDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.map = new HashMap<>();
    }

    private RowMapper<InsurancePolicy> rowMapper = ((rs, rowNum) -> {
       Long currentId = rs.getLong(1);
       if (map.get(currentId) == null){
           map.put(currentId, InsurancePolicy.builder()
           .id(rs.getLong(1))
           .passport_series(rs.getString(2))
           .price(rs.getLong(3))
           .expiration_date(rs.getDate(4).toLocalDate())
           .build());
        }
        return map.get(currentId);
    });

    @Override
    public void save(InsurancePolicy model) {
        template.update(con -> {
            PreparedStatement statement =
                    con.prepareStatement(INSERT_INSURANCE_FOR_ONE);
            statement.setLong(1, model.getId());
            statement.setString(2, model.getPassport_series());
            statement.setLong(3, model.getPrice());
            statement.setObject(4, model.getExpiration_date());
            return statement;
        });
    }

    @Override
    public InsurancePolicy find(Long id) {
        InsurancePolicy insurancePolicy;
        try {
            insurancePolicy = template.query(SELECT_INSURANCE_FOR_ONE_BY_ID, new Long[]{id}, rowMapper).get(0);
        }catch (IndexOutOfBoundsException e){
            insurancePolicy = null;
        }
        map.clear();
        return insurancePolicy;
    }

    @Override
    public void update(InsurancePolicy model) {

    }

    @Override
    public void delete(InsurancePolicy model) {

    }

    @Override
    public List<InsurancePolicy> findAll() {
        return null;
    }
}
