package com.delly.DellyApp.repository;

import com.delly.DellyApp.model.TripPoint;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository related to trip point.
 */
public interface TripPointRepository extends CrudRepository<TripPoint, Long> {
}
