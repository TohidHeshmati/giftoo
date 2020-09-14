package com.project.giftoo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NonNull
    @Size(max = 15)
    private String text;

    @OneToMany
    private List<Wish> wishes = new ArrayList<>();

    @OneToMany
    private List<WishList> wishLists = new ArrayList<>();

    @PreUpdate
    @PrePersist
    public void validate() throws ValidationException {
        if (wishes.isEmpty() && wishLists.isEmpty())
            throw new ValidationException("a tag should belong to either a wish or wishlist");
    }
}