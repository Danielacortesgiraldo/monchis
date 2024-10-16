package com.monchisfrozenfood.controller;

import com.monchisfrozenfood.controller.request.UserRequest;
import com.monchisfrozenfood.controller.response.UserResponse;
import com.monchisfrozenfood.entitys.User;
import com.monchisfrozenfood.services.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/v1")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    String message = "Operation completed successfully.";

    @GetMapping("/list")
    public ResponseEntity<List<User>> userListApi() {
        List<User> usersList = userService.getUsersList();
        return new ResponseEntity<>(usersList, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserByIdApi(@RequestParam(name = "userId") Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.accepted().body(message);
    }

    @GetMapping("/search/{userId}")
    public ResponseEntity<UserResponse> searchUserApi(@PathVariable Long userId) {
        UserResponse userResponse = userService.searchUser(userId);
        return ResponseEntity.accepted().body(userResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUserApi(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUserApi(@RequestBody UserRequest userRequest) {
        userService.updateUser(userRequest);
        return ResponseEntity.accepted().body(message);
    }
}
