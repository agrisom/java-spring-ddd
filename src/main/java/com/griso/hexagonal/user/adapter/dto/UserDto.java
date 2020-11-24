package com.griso.hexagonal.user.adapter.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class UserDto {

    @Id
    private String id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private Date birthday;

}
