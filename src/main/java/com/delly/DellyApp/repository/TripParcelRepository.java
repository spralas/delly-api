package com.delly.DellyApp.repository;

import com.delly.DellyApp.model.TripParcel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TripParcelRepository extends CrudRepository<TripParcel, Long> {
    @Query("SELECT tp FROM TripParcel tp WHERE tp.id = ?1")
    TripParcel findTripParcelById(Long id);
}
