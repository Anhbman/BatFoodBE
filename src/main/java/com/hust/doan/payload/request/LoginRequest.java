package com.hust.doan.payload.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

//@Getter(AccessLevel.PUBLIC)
//@Setter(AccessLevel.PUBLIC
//)
@Data
public class LoginRequest {

    @NotNull(message = "username cannot null")
    private String username;

    @NotNull(message = "password cannot null")
    private String password;

}
