package ru.info.tech.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


/**
 * Created by Sulaymon on 21.10.2017.
 */
@Setter
@Getter
@Builder
public class InsurancePolicy {
    private Long id;
    private String passport_series;
    private Long price;
    private LocalDate expiration_date;
}
