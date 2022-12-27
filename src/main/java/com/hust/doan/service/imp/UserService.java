package com.hust.doan.service.imp;

import com.hust.doan.exception.UserExitsException;
import com.hust.doan.model.User;
import com.hust.doan.repository.RoleRepository;
import com.hust.doan.repository.UserRepository;
import com.hust.doan.service.imp.UserDetailsImpl;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username" + username));
    }

    public Boolean exitsUserName(String username) {
        return userRepository.existsByUsername(username);
    }

    public User add(User user) {
       try {
           User user1 = userRepository.save(user);
           if (user1 == null) {
               throw new RuntimeException("Cannot save user: " + user1.getUsername());
           }
           return user1;
       } catch (DataIntegrityViolationException exception) {
           exception.printStackTrace();
           throw new UserExitsException(user.getUsername());
       }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);
        return UserDetailsImpl.build(user);
    }
}
