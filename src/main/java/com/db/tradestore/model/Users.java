package com.db.tradestore.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Table(name = "USERS")
public class Users {

    @Id
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ISACTIVE")
    private boolean isActive;

    @ElementCollection
    @JoinTable(
            name = "roles",
            joinColumns = {@JoinColumn(name = "username")})
    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(name = "role")
    private Set<String> roles;
}
