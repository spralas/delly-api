package com.delly.DellyApp.model;

import com.delly.DellyApp.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="D_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name="LAST_NAME", nullable = false)
    private String lastName;

    @Column(name="EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name="PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name="STRIPE_CUSTOMER_ID")
    private String stripeCustomerId;

    @Column(name="USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="ACTIVE", nullable = false)
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private Role role;
}
