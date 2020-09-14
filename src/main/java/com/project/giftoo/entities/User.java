package com.project.giftoo.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    // TODO implement User and Role Entity at the end
    // TODO to: wishlist, wish, vote, comment

    @Id
    @NotNull
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;
    private String lastName;
    private String showName;

    @Size(min = 8, max = 31)
    private String email;

    @NotNull @NonNull
    private String userName;

    @Lob
    private Byte[] userImage;

    @Lob
    private Byte[] headerImage;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    private Date birthDate;




}
