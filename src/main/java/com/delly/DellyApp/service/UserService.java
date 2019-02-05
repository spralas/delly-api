package com.delly.DellyApp.service;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.User;

/**
 * Interface for users.
 *
 * @author spralas
 */
public interface UserService {

    User createNewUser(UserRequestDto newUser);

    User findUser(Long id);
}
