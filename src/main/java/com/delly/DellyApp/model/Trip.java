package com.delly.DellyApp.model;

import com.delly.DellyApp.enums.Currency;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="TRIP")
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRIP_ID")
    private Long tripId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "VEHICLE_ID", nullable = false)
    private Vehicle vehicle;

    @Column(name="START_TIME", nullable = false)
    private LocalDateTime startTime;

    @Column(name="END_TIME", nullable = false)
    private LocalDateTime endTime;

    @Column(name="PRICE_PER_PARCEL", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY")
    private Currency currency;
}
