package com.sdechcode.springsecuritydemo.api.user;

import com.sdechcode.springsecuritydemo.dto.user.UserDto;
import com.sdechcode.springsecuritydemo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return List.of();
    }

    @Override
    public UserDto findById(Long userID) {
        return null;
    }

    @Override
    public UserDto save(UserDto request) {
        return null;
    }

    @Override
    public UserDto update(Long userID, UserDto request) {
        return null;
    }

    @Override
    public void delete(Long userID) {

    }

}
