package com.project.giftoo.entity;

import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

//    @ManyToMany( mappedBy = "roles")
//    private Collection<User> users;

}
