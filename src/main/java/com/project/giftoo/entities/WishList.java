package com.project.giftoo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class WishList {
    //TODO user

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String description;

    // TODO: make it multiple image
    private byte[] image;

    private byte priority;

    @OneToMany
    @JoinColumn(name = "wish")
    private List<Wish> wishes = new ArrayList<Wish>();

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();
}
