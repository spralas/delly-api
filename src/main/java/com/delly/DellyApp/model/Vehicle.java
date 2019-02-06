package com.delly.DellyApp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="VEHICLE")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="VEHICLE_ID")
    private Long vehicleId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name="VEHICLE_NAME", nullable = false)
    private String vehicleName;

    @Column(name="LICENCE_PLATE", nullable = false)
    private String licencePlate;
}
