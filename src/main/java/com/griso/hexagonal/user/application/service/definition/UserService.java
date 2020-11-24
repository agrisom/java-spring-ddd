package com.griso.hexagonal.user.application.service.definition;

import com.griso.hexagonal.user.domain.model.User;

public interface UserService {

    User save(User user);
    User findByUsername(String username);

}
