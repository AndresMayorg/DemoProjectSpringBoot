package com.project.demo.project.service;

import com.project.demo.project.persistence.entity.UserEntity;
import com.project.demo.project.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User " +username+ " not found"));
        return User.builder().username(userEntity.getUsername()).password(userEntity.getPassword()).disabled(userEntity.isDisabled()).accountLocked(userEntity.isLocked()).build();
    }
}
