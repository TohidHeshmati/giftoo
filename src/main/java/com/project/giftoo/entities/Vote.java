package com.project.giftoo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Vote {
    //TODO to: user

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "upvote or down-vote should be set") @NonNull
    private short upOrDown;

    @ManyToOne
    private Wish wish;

    @ManyToOne
    private Comment comment;

    @PrePersist
    @PreUpdate
    private void validate() throws ValidationException {
        if (wish == null && comment == null) {
            throw new ValidationException("vote belongs to either comment or wish");
        }
    }
}
