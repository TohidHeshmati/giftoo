package com.project.giftoo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull @NotNull(message = "name of the role is a must")
    private String name;

    @ManyToMany( mappedBy = "roles")
    private Collection<User> users;

}
