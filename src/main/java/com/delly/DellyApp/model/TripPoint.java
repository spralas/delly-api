package com.delly.DellyApp.model;

import com.delly.DellyApp.enums.TripPointType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="TRIP_POINT")
public class TripPoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRIP_POINT_ID")
    private Long tripPointId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "TRIP_ID", nullable = false)
    private Trip trip;

    @Column(name="STREET", nullable = false)
    private String street;

    @Column(name="CITY", nullable = false)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRIP_POINT_TYPE")
    private TripPointType tripPointType;
}
