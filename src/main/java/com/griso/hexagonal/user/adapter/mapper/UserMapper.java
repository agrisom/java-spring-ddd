package com.griso.hexagonal.user.adapter.mapper;

import com.griso.hexagonal.user.adapter.dto.UserDto;
import com.griso.hexagonal.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto user);
    UserDto toUserDto(User user);

}
