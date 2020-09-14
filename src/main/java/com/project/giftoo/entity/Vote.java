package com.project.giftoo.entity;

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

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
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
