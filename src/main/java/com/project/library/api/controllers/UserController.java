package com.project.library.api.controllers;

import com.project.library.api.controllers.mappers.UserMapper;
import com.project.library.api.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;



}
