package com.griso.hexagonal.authentication.adapter.rest.controller.definition;

import com.griso.hexagonal.authentication.adapter.dto.AuthenticationRequest;
import com.griso.hexagonal.authentication.adapter.dto.AuthenticationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationController {

    @PostMapping
    AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest);

}
