package com.griso.hexagonal.authentication.adapter.rest.controller.implementation;

import com.griso.hexagonal.authentication.adapter.dto.AuthenticationRequest;
import com.griso.hexagonal.authentication.adapter.dto.AuthenticationResponse;
import com.griso.hexagonal.authentication.adapter.mapper.AuthenticationMapper;
import com.griso.hexagonal.authentication.adapter.rest.controller.definition.AuthenticationController;
import com.griso.hexagonal.authentication.application.service.implementation.AuthenticationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/v1/public/authenticate")
@Api(tags = "Authentication user APIs")
public class AuthenticationControllerV1 implements AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    AuthenticationMapper authenticationMapper;

    @Override
    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(authenticationService.authenticate(authenticationMapper.toUser(authenticationRequest)));
        return authenticationResponse;
    }
}
