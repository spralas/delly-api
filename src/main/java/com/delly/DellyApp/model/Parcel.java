package com.delly.DellyApp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="PARCEL")
public class Parcel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PARCEL_ID")
    private Long parcelId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name="START_STREET", nullable = false)
    private String startStreet;

    @Column(name="START_CITY", nullable = false)
    private String startCity;

    @Column(name="END_TIME", nullable = false)
    private LocalDateTime endTime;

    @Column(name="END_STREET", nullable = false)
    private String endStreet;

    @Column(name="END_CITY", nullable = false)
    private String endCity;

}
