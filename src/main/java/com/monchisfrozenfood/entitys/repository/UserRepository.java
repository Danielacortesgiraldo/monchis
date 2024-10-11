package com.monchisfrozenfood.entitys.repository;

import com.monchisfrozenfood.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> userList();

    @Override
    List<User> findAll();
}
