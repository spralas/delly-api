package com.delly.DellyApp.service.impl;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.model.Vehicle;
import com.delly.DellyApp.repository.VehicleRepository;
import com.delly.DellyApp.service.UserService;
import com.delly.DellyApp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link VehicleService} interface.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserService userService;

    @Override
    public Vehicle createNewVehicle(UserRequestDto user) {
        User insertedUser = userService.findUserByUserNameOrEmail(user.getUserName(), user.getEmail());
        Vehicle vehicle = new Vehicle();
        vehicle.setUser(insertedUser);
        vehicle.setVehicleName(user.getVehicleName());
        vehicle.setLicencePlate(user.getLicensePlate());
        vehicleRepository.save(vehicle);

        return vehicle;
    }

    @Override
    public Vehicle findVehicleById(Long id) {
        return vehicleRepository.findVehicleById(id);
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }
}
