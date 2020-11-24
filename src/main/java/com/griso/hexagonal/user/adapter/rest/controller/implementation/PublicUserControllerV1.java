package com.griso.hexagonal.user.adapter.rest.controller.implementation;

import com.griso.hexagonal.user.adapter.dto.UserDto;
import com.griso.hexagonal.user.adapter.mapper.UserMapper;
import com.griso.hexagonal.user.adapter.repository.UserRepositoryMongoDb;
import com.griso.hexagonal.user.adapter.rest.controller.definition.PublicUserController;
import com.griso.hexagonal.user.application.service.definition.UserService;
import com.griso.hexagonal.user.application.service.implementation.UserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/v1/public/user")
@Api(tags = "Public user APIs")
public class PublicUserControllerV1 implements PublicUserController {

    UserService userService;

    @Autowired
    UserRepositoryMongoDb userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto save(UserDto user) {
        userService = new UserServiceImpl(userRepository);
        return userMapper.toUserDto(userService.save(userMapper.toUser(user)));
    }

}
