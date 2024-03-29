package com.delly.DellyApp.repository;

import com.delly.DellyApp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository related to user.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findUserById(Long id);

    @Query("SELECT u FROM User u WHERE u.username = ?1 or u.email=?1")
    User findUserByUsernameOrEmail(String userData);
}
