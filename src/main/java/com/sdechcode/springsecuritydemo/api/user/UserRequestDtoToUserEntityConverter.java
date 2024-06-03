package com.sdechcode.springsecuritydemo.api.user;

import com.sdechcode.springsecuritydemo.dto.user.UserRequestDto;
import com.sdechcode.springsecuritydemo.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoToUserEntityConverter implements Converter<UserRequestDto, UserEntity> {

    @Override
    public UserEntity convert(UserRequestDto source) {
        UserEntity user = new UserEntity();
        user.setUsername(source.username());
        user.setPassword(source.password());
        user.setEnabled(source.enabled());
        user.setRoles(source.roles());
        return user;
    }

}
