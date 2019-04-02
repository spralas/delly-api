package com.delly.DellyApp.model;

import com.delly.DellyApp.enums.TripPointType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="TRIP_PARCEL")
public class TripParcel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRIP_PARCEL_ID")
    private Long tripParcelId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "TRIP_ID", nullable = false)
    private Trip trip;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}

