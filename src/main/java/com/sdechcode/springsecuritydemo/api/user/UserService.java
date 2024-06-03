package com.sdechcode.springsecuritydemo.api.user;

import com.sdechcode.springsecuritydemo.dto.user.UserRequestDto;
import com.sdechcode.springsecuritydemo.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();

    UserResponseDto findById(Long userID);

    UserResponseDto save(UserRequestDto request);

    UserResponseDto update(Long userID, UserRequestDto request);

    void delete(Long userID);
}
