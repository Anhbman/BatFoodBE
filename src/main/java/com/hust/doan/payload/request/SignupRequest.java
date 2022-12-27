package com.hust.doan.payload.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SignupRequest {

    @NotNull(message = "username cannot null")
    private String username;

    @NotNull(message = "fullName cannot null")
    private String fullName;

    @NotNull(message = "password cannot null")
    private String password;

    @NotNull(message = "email cannot null")
    @Email
    private String email;

//    @NotNull(message = "password confirmation cannot null")
//    private String passwordConfirmation;

    private List<String> roles;
}
