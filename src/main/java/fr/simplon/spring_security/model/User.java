package fr.simplon.spring_security.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String displayName;
    private String email;
    private String password;

    @Column(name = "creation_date",updatable = false)
    @CreationTimestamp
    private LocalDate creationDate;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserInShop> userInShops = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Address> addressBook = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserRole role;


}
