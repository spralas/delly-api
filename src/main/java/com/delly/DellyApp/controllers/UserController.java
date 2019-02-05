package com.delly.DellyApp.controllers;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for users.
 *
 * @author spralas
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create new user.
     *
     * @return ResponseEntity that contains status and inserted user.
     */
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserRequestDto user){
        User userInserted = userService.createNewUser(user);
        User insertedUser = userService.findUser(userInserted.getUserId());

        return ResponseEntity.ok(insertedUser);
    }
}
