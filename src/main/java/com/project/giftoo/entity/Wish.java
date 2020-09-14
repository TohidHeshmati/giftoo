package com.project.giftoo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Wish {
    //TODO to: user

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String description;

    // TODO: make it multiple image
    private byte[] image;

    private String link;

    @NonNull
    private String name;

    private BigDecimal priceFrom;

    private BigDecimal priceTo;

    @NonNull
    private byte priority;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    private Date dueDate;

    @ManyToOne
    private WishList wishList;

    @OneToMany
    @JoinColumn(name = "vote")
    private List<Vote> votes = new ArrayList<>();

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    @OneToMany
    List<Comment> comments = new ArrayList<>();
}
