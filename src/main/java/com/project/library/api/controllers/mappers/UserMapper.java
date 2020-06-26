package com.project.library.api.controllers.mappers;

import com.project.library.api.domain.User;
import com.project.library.api.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getJoiningDate()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getJoiningDate()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(
                        t.getId(),
                        t.getFirstName(),
                        t.getLastName(),
                        t.getJoiningDate()))
                .collect(Collectors.toList());
    }
}
