package ru.info.tech.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Sulaymon on 22.10.2017.
 */
@Setter
@Getter
@Builder
@ToString
public class UsersInsurancePolicy {
    private Long id;
    private String name;
    private int age;
    private String passport_series;
    private Long price;
    private LocalDate expiration_date;
}
