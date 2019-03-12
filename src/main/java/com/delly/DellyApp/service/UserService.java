package com.delly.DellyApp.service;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.User;

import java.util.List;

/**
 * Interface for users.
 *
 * @author spralas
 */
public interface UserService {

    User createNewUser(UserRequestDto newUser);

    User findUserById(Long id);

    User findUserByUserNameOrEmail(String userData);

    List<User> findAllUsers();
}
