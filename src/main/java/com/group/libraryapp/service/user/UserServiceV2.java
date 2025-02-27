package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //저장
    @Transactional
    public void saveUser(UserCreateRequest request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    //조회
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }

    //업데이트
    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);  //유저가 없다면 예외처리

        user.updateName(request.getName());
    }

    //삭제
    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new IllegalArgumentException();
        }

        userRepository.delete(user);
    }
}
