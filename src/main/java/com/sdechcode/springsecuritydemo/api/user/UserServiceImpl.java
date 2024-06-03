package com.sdechcode.springsecuritydemo.api.user;

import com.sdechcode.springsecuritydemo.dto.user.UserRequestDto;
import com.sdechcode.springsecuritydemo.dto.user.UserResponseDto;
import com.sdechcode.springsecuritydemo.entity.UserEntity;
import com.sdechcode.springsecuritydemo.repo.UserRepository;
import com.sdechcode.springsecuritydemo.system.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRequestDtoToUserEntityConverter userRequestDtoToUserEntityConverter;

    @Override
    public List<UserResponseDto> findAll() {
        List<UserEntity> users = this.userRepository.findAll();
        return users.stream()
                .map(u -> new UserResponseDto(u.getId(), u.getUsername(), u.getEnabled(), u.getRoles()))
                .toList();
    }

    @Override
    public UserResponseDto findById(Long userID) {
        UserEntity user = this.userRepository.findById(userID)
                .orElseThrow(() -> new ObjectNotFoundException("user", userID));
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEnabled(), user.getRoles());
    }

    @Override
    public UserResponseDto save(UserRequestDto request) {
        UserEntity newUser = this.userRequestDtoToUserEntityConverter.convert(request);
        UserEntity savedUser = this.userRepository.save(newUser);
        return new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEnabled(), savedUser.getRoles());
    }

    @Override
    public UserResponseDto update(Long userID, UserRequestDto request) {
        UserEntity oldUser = this.userRepository.findById(userID)
                .orElseThrow(() -> new ObjectNotFoundException("user", userID));
        oldUser.setUsername(request.username());
        oldUser.setPassword(request.password());
        oldUser.setEnabled(request.enabled());
        oldUser.setRoles(request.roles());
        UserEntity updatedUser = this.userRepository.save(oldUser);
        return new UserResponseDto(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getEnabled(), updatedUser.getRoles());
    }

    @Override
    public void delete(Long userID) {
        this.userRepository.findById(userID)
                .orElseThrow(() -> new ObjectNotFoundException("user", userID));
        this.userRepository.deleteById(userID);
    }

}
