package com.monchisfrozenfood.services;

import com.monchisfrozenfood.controller.request.UserRequest;
import com.monchisfrozenfood.controller.response.DocumentTypeResponse;
import com.monchisfrozenfood.controller.response.UserResponse;
import com.monchisfrozenfood.entitys.DocumentType;
import com.monchisfrozenfood.entitys.User;
import com.monchisfrozenfood.entitys.repository.UserRepository;
import com.monchisfrozenfood.services.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsersList() {
        return userRepository.usersList();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse searchUser(Long userId) {
       User user =  userRepository.searchUser(userId);

       return Objects.nonNull(user)
               ? buildUserResponse(user)
               : UserResponse.builder().build();
    }

    @Override
    public void saveUser(UserRequest userRequest) {
        if (Objects.nonNull(userRequest)) {
            User user = buildUserEntity(userRequest);
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(UserRequest userRequest) {
        if (Objects.nonNull(userRequest)) {
           Optional<User> user = userRepository.findById(userRequest.getUserId());
           if (user.isPresent()) {
               User updatedUser = buildUserEntity(userRequest);
               userRepository.save(updatedUser);
           }
        }
    }

    private static UserResponse buildUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userLastName(user.getUserLastName())
                .documentTypeResponse(buildDocumentTypeResponse(user.getFkDocumentTypeId()))
                .userDocument(user.getUserDocument())
                .userEmail(user.getUserEmail())
                .build();
    }

    private static DocumentTypeResponse buildDocumentTypeResponse(DocumentType documentType) {
         return DocumentTypeResponse.builder()
                .documentTypeId(documentType.getDocumentTypeId())
                .documentTypeAcronym(documentType.getDocumentTypeAcronym())
                .documentTypeDescription(documentType.getDocumentTypeDescription())
                .build();
    }

    private static User buildUserEntity(UserRequest userRequest) {
        return User.builder()
                .userId(userRequest.getUserId())
                .userName(userRequest.getUserName())
                .userLastName(userRequest.getUserLastName())
                .fkDocumentTypeId(buildDocumentTypeEntity(userRequest))
                .userDocument(userRequest.getUserDocument())
                .userEmail(userRequest.getUserEmail())
                .password(userRequest.getPassword())
                .build();
    }

    private static DocumentType buildDocumentTypeEntity(UserRequest userRequest) {
        return DocumentType.builder()
                .documentTypeId(userRequest.getFkDocumentTypeId())
                .build();
    }
}
