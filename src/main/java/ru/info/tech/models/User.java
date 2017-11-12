package ru.info.tech.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sulaymon on 15.10.2017.
 */
@Getter
@Setter
public class User extends Human{
    private Long id;
    private String email;
    private String address;
    private String tel;
    private String username;
    private String hashPassword;

    @Builder
    private User(String name, String surname, String lastname, String age, Long id, String email, String address, String tel, String username, String hashPassword) {
        super(name, surname, lastname, age);
        this.id = id;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.username = username;
        this.hashPassword = hashPassword;
    }

}
