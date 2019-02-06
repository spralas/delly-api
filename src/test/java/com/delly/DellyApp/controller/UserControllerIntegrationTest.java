package com.delly.DellyApp.controller;


import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.enums.Role;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.model.Vehicle;
import com.delly.DellyApp.repository.UserRepository;
import com.delly.DellyApp.repository.VehicleRepository;
import com.delly.DellyApp.service.UserService;
import com.delly.DellyApp.service.VehicleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @After
    public void clearDb() {
        List<Vehicle> vehicles = vehicleService.findAllVehicles();
        vehicles.stream().forEach(vehicle -> vehicleRepository.delete(vehicle));
        List<User> users = userService.findAllUsers();
        users.stream().forEach(user -> userRepository.delete(user));

    }

    @Test
    @DisplayName("Integration test which will check if user is inserted")
    public void insertUser() {

        User userInserted = userService.createNewUser(createUserRequest());
        User insertedUser = userService.findUserById(userInserted.getUserId());

        assertThat(insertedUser.getFirstName(), is(equalTo("User name")));
        assertThat(insertedUser.getLastName(), is(equalTo("Last name")));
        assertThat(insertedUser.getUsername(), is(equalTo("Username")));
        assertTrue(new BCryptPasswordEncoder().matches("Password", insertedUser.getPassword()));
        assertNotNull(insertedUser.getStripeCustomerId());
    }

    @Test
    @DisplayName("Integration test which will check if vehicle is inserted when driver role checked")
    public void insertVehicle() {
        User userInserted = userService.createNewUser(createUserRequest());
        Vehicle vehicle = vehicleService.createNewVehicle(createUserRequest());
        Vehicle insertedVehicle = vehicleService.findVehicleById(vehicle.getVehicleId());

        assertNotNull(insertedVehicle.getVehicleId());
        assertThat(insertedVehicle.getVehicleName(), is(equalTo("Golf 5")));
        assertThat(insertedVehicle.getLicencePlate(), is(equalTo("ZG1234DD")));
    }

    private UserRequestDto createUserRequest() {
        UserRequestDto user = new UserRequestDto();
        user.setFirstName("User name");
        user.setLastName("Last name");
        user.setEmail("mail@mail.com");
        user.setPhoneNumber("0996116789");
        user.setRole(Role.DRIVER);
        user.setUserName("Username");
        user.setPassword("Password");
        user.setStripeToken("tok_visa");
        user.setVehicleName("Golf 5");
        user.setLicensePlate("ZG1234DD");

        return user;
    }
}
