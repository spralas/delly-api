package com.delly.DellyApp.service;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.User;

import java.util.List;

/**
 * Interface for users.
 */
public interface UserService {

    /**
     * Creates new user.
     *
     * @param newUser New user.
     * @return User.
     */
    User createNewUser(UserRequestDto newUser);

    /**
     * Find user using id.
     *
     * @param id User id.
     * @return User.
     */
    User findUserById(Long id);

    /**
     * Find user using username or email.
     *
     * @param userData Username or email.
     * @return User.
     */
    User findUserByUserNameOrEmail(String userData);

    /**
     * Fetch all users.
     *
     * @return List of users.
     */
    List<User> findAllUsers();
}
