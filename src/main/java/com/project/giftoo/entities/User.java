package com.project.giftoo.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User implements UserDetails {

    // TODO implement User and Role Entity at the end
    // TODO to: wishlist, wish, vote, comment

    @Id
    @NotNull
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;
    private String lastName;

    @Size(min = 8, max = 31)
    private String email;

    @NotNull @NonNull
    private String userName;

    @NotNull @NonNull
    private String password;

    @Lob
    private Byte[] userImage;

    @Lob
    private Byte[] headerImage;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    private Date birthDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    public String getFullname() {
        return firstName + " " + lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authurities = new ArrayList<>();
        for (Role role : roles) {
            authurities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authurities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
