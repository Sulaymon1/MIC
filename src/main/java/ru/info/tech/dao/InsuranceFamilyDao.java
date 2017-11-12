package ru.info.tech.dao;

import ru.info.tech.models.UsersInsurancePolicy;

import java.util.List;

/**
 * Created by Sulaymon on 22.10.2017.
 */
public interface InsuranceFamilyDao extends CrudDao<UsersInsurancePolicy, Long> {
    List<UsersInsurancePolicy> findAllById(Long id);
}
