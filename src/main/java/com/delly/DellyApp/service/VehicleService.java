package com.delly.DellyApp.service;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.Vehicle;

import java.util.List;

/**
 * Interface for vehicle.
 */
public interface VehicleService {

    /**
     * Creates a new vehicle.
     *
     * @param user User request dto.
     * @return Vehicle.
     */
    Vehicle createNewVehicle(UserRequestDto user);

    /**
     * Search for vehicle using vehicle id.
     *
     * @param id Vehicle id.
     * @return Vehicle.
     */
    Vehicle findVehicleById(Long id);

    /**
     * Searching for all vehicles.
     *
     * @return List of vehicles.
     */
    List<Vehicle> findAllVehicles();
}
