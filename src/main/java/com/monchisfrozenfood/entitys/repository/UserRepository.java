package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> usersList();

    @Query(value = "SELECT * FROM users WHERE user_id = :userId", nativeQuery = true)
    User searchUser(@Param("userId") Long userId);

}
