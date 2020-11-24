package com.griso.hexagonal.user.adapter.rest.controller.definition;

import com.griso.hexagonal.user.adapter.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PublicUserController {

    @PostMapping
    UserDto save(@RequestBody UserDto user);

}
