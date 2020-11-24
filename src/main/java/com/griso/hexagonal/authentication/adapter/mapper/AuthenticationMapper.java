package com.griso.hexagonal.authentication.adapter.mapper;

import com.griso.hexagonal.authentication.adapter.dto.AuthenticationRequest;
import com.griso.hexagonal.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthenticationMapper {

    User toUser(AuthenticationRequest authenticationRequest);

}
