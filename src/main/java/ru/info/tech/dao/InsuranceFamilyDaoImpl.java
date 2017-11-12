package ru.info.tech.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.info.tech.models.InsurancePolicy;
import ru.info.tech.models.UsersInsurancePolicy;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sulaymon on 22.10.2017.
 */
public class InsuranceFamilyDaoImpl implements InsuranceFamilyDao {
    private JdbcTemplate template;
    private Map<Long, UsersInsurancePolicy> insurancePolicyMap;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private InsuranceFamilyDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.template = new JdbcTemplate(dataSource);
        this.insurancePolicyMap = new HashMap<>();
    }

    private RowMapper<UsersInsurancePolicy> rowMapper = ((rs, rowNum) -> {
        Long currentId = rs.getLong(1);
        if (insurancePolicyMap.get(currentId) == null) {
            insurancePolicyMap.put(currentId, UsersInsurancePolicy.builder()
                    .id(currentId)
                    .name(rs.getString(2))
                    .age(rs.getInt(3))
                    .passport_series(rs.getString(4))
                    .price(rs.getLong(5))
                    .expiration_date(rs.getObject(6, LocalDate.class))
                    .build());
        }
        return insurancePolicyMap.get(currentId);
    });


    @Override
    public void save(UsersInsurancePolicy model) {
        template.update(con -> {
            PreparedStatement statement =
                    con.prepareStatement("INSERT INTO insurance_family(id, name, age, passport_series, price, expiration_date) VALUES(?,?,?,?,?,?)");
            statement.setLong(1, model.getId());
            statement.setString(2, model.getName());
            statement.setInt(3, model.getAge());
            statement.setString(4, model.getPassport_series());
            statement.setLong(5, model.getPrice());
            statement.setObject(6, model.getExpiration_date());
            return statement;
        });
    }

    @Override
    public UsersInsurancePolicy find(Long id) {
        UsersInsurancePolicy policy = template.query("SELECT * FROM insurance_family", new Long[]{id}, rowMapper).get(0);
        insurancePolicyMap.clear();
        return policy;
    }

    @Override
    public void update(UsersInsurancePolicy model) {

    }

    @Override
    public void delete(UsersInsurancePolicy model) {

    }

    @Override
    public List<UsersInsurancePolicy> findAll() {
        return null;
    }

    @Override
    public List<UsersInsurancePolicy> findAllById(Long id) {
        Map<String, Long> param = new HashMap<>();
        param.put("id", id);
        List<UsersInsurancePolicy> policyList = namedParameterJdbcTemplate.query("SELECT * FROM insurance_family WHERE id=:id", param ,rowMapper);
        insurancePolicyMap.clear();
        return policyList;
    }
}

