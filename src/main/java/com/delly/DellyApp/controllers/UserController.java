package com.delly.DellyApp.controllers;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.enums.Role;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.model.Vehicle;
import com.delly.DellyApp.service.EmailService;
import com.delly.DellyApp.service.UserService;
import com.delly.DellyApp.service.VehicleService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for users.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private static final String EMAIL_SUBJECT = "You are now Delly member. Thank you!";
    private static final String EMAIL_TEXT = "Thank you for entering in Delly's world!";

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private VehicleService vehicleService;

    /**
     * Create new user and sends mail notification.
     *
     * @return ResponseEntity that contains status and inserted user.
     */
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody UserRequestDto user) {
        if (userService.findUserByUserNameOrEmail(user.getUserName()) != null ||
                userService.findUserByUserNameOrEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("User is already registered.", HttpStatus.METHOD_NOT_ALLOWED);
        }
        User userInserted = userService.createNewUser(user);

        if (Role.DRIVER.equals(user.getRole())) {
            Vehicle vehicle = vehicleService.createNewVehicle(user);
            Assert.notNull(vehicle);
        }
        User insertedUser = userService.findUserById(userInserted.getUserId());

        if (insertedUser != null) {
            try {
                emailService.sendMail(insertedUser.getEmail(), EMAIL_SUBJECT, EMAIL_TEXT);
            } catch (Exception e) {
                return new ResponseEntity<>("Exception occurred during mail sending.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>("New user has been created.", HttpStatus.OK);
    }
}
