package com.hust.doan.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtResponse {

    @NotNull(message = "token cannot null")
    private String token;

    @NotNull(message = "Id cannot null")
    private Long id;

    @NotNull(message = "username cannot null")
    private String username;

    @NotNull(message = "fullName cannot null")
    private String fullName;

    @NotNull(message = "role cannot null")
    private List<String> role;
}
