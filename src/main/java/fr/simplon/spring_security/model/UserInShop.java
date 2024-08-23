package fr.simplon.spring_security.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_in_shop")
public class UserInShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(nullable = false)
    private Timestamp joinDate;

    @Enumerated(EnumType.STRING)
    private UserRole role;


}
