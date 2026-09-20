package com.mini.Authentication.service;

import com.mini.Authentication.model.User;
import com.mini.Authentication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
      private final UserRepository userRepository;
      public CustomUserDetailsService(UserRepository userRepository) {
          this.userRepository = userRepository;
      }

      @Override
      public UserDetails loadUserByUsername(String name){
          Optional<User> user = userRepository.findByUsername(name);
          if(!user.isPresent()){
              throw new UsernameNotFoundException("Username not found");
          }
          User dbUser = user.get();
          return org.springframework.security.core.userdetails.User
                  .withUsername(dbUser.getUsername())
                  .password(dbUser.getPassword())
                  .authorities("USER")
                  .build();
      }
}
