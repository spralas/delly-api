package com.delly.DellyApp.repository;

import com.delly.DellyApp.model.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository related to trip.
 */
public interface TripRepository extends CrudRepository<Trip, Long> {
    @Query("SELECT t FROM Trip t WHERE t.id = ?1")
    Trip findTripById(Long id);
}
