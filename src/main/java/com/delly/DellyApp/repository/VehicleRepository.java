package com.delly.DellyApp.repository;

import com.delly.DellyApp.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository related to vehicle.
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE v.id = ?1")
    Vehicle findVehicleById(Long id);
}

