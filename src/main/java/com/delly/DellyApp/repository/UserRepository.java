package com.delly.DellyApp.repository;

import com.delly.DellyApp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findOne(Long id);
}
