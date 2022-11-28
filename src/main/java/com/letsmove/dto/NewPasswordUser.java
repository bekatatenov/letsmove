package com.letsmove.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewPasswordUser {
    private String email;
    private String password;
    private String repeatPassword;
    private Integer token;

}
