package com.hust.doan.model;

import com.hust.doan.model.type.Gender;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
public class User extends BaseEntity{

    @NotNull(message = "Username cannot null")
    private String username;

    @NotNull(message = "email cannot null")
    private String email;

    @NotNull(message = "Password cannot null")
    private String password;

    @NotNull(message = "fullName cannot null")
    private String fullName;

    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }
}
