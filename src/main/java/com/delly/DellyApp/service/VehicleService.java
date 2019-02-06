package com.delly.DellyApp.service;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.Vehicle;

import java.util.List;

/**
 * Interface for vehicle.
 *
 * @author spralas
 */
public interface VehicleService {

    Vehicle createNewVehicle(UserRequestDto user);

    Vehicle findVehicleById(Long id);

    List<Vehicle> findAllVehicles();
}
