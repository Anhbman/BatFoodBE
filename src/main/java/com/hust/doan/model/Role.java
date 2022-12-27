package com.hust.doan.model;

import com.hust.doan.model.type.ERole;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role (ERole eRole) {
        this.name = eRole;
    }

//    @ManyToMany
//    @JoinTable(
//        name = "user_role",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<User> users;
}
