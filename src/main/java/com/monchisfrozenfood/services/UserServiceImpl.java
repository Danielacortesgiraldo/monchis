package com.monchisfrozenfood.services;

import com.monchisfrozenfood.entitys.User;
import com.monchisfrozenfood.entitys.repository.UserRepository;
import com.monchisfrozenfood.services.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsersList() {
        return userRepository.userList();
    }
}
