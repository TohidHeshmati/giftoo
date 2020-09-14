package com.project.giftoo.entity;

import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull @NotNull(message = "name of the role is a must")
    private String name;

//    @ManyToMany( mappedBy = "roles")
//    private Collection<User> users;

}
