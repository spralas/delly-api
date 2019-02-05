package com.delly.DellyApp.controller;


import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.enums.Role;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerIntegrationTest {
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Integration test which will check if user is inserted")
    public void insertUser(){

        User userInserted = userService.createNewUser(createUserRequest());
        User insertedUser = userService.findUser(userInserted.getUserId());

        assertThat(insertedUser.getFirstName(), is(equalTo("User name")));
        assertThat(insertedUser.getLastName(), is(equalTo("Last name")));
        assertThat(insertedUser.getUsername(), is(equalTo("Username")));
        assertTrue(new BCryptPasswordEncoder().matches("Password", insertedUser.getPassword()));
        assertNotNull(insertedUser.getStripeCustomerId());
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

        return user;
    }
}
