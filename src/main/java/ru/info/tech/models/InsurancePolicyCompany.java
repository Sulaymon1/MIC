package ru.info.tech.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sulaymon on 24.10.2017.
 */
@Setter
@Getter
@Builder
public class InsurancePolicyCompany {
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private int age;
    private String passport_series;
    private String expiration_date;
}
