package com.project.giftoo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Comment {
    //TODO to: user

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "comment can not have no text") @NonNull
    @Size(max = 255)
    private String text;

    @OneToMany
    @JoinColumn(name = "vote")
    private List<Vote> votes = new ArrayList<>();

    @NotNull
    @ManyToOne
    private Wish wish;

}
