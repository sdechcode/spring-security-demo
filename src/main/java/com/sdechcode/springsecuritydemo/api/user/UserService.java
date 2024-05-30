package com.sdechcode.springsecuritydemo.api.user;

import com.sdechcode.springsecuritydemo.dto.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long userID);

    UserDto save(UserDto request);

    UserDto update(Long userID, UserDto request);

    void delete(Long userID);
}
