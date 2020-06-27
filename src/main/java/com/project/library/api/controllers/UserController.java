package com.project.library.api.controllers;

import com.project.library.api.controllers.mappers.UserMapper;
import com.project.library.api.domain.dto.UserDto;
import com.project.library.api.exceptions.UserNotFoundException;
import com.project.library.api.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/users")
    @ResponseBody
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public UserDto getUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUserById(userId).orElseThrow(UserNotFoundException::new));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
    }

    @PutMapping("")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }

    @PostMapping("")
    @ResponseBody
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.mapToUser(userDto));
    }
}
