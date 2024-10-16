package com.monchisfrozenfood.services.service;

import com.monchisfrozenfood.controller.request.UserRequest;
import com.monchisfrozenfood.controller.response.UserResponse;
import com.monchisfrozenfood.entitys.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();
    void deleteUserById(Long userId);
    UserResponse searchUser(Long userId);
    void saveUser(UserRequest userRequest);
    void updateUser(UserRequest userRequest);
}
