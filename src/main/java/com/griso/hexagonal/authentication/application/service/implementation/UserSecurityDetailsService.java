package com.griso.hexagonal.authentication.application.service.implementation;

import com.griso.hexagonal.authentication.domain.model.UserSecurity;
import com.griso.hexagonal.user.adapter.repository.UserRepositoryMongoDb;
import com.griso.hexagonal.user.application.service.implementation.UserServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityDetailsService implements UserDetailsService {

	private final UserRepositoryMongoDb userRepository;

	public UserSecurityDetailsService(UserRepositoryMongoDb userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		return new UserSecurity(new UserServiceImpl(userRepository).findByUsername(username));
	}

}
