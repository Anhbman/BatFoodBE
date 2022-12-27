package com.hust.doan.controller;

import com.hust.doan.jwt.JwtUtils;
import com.hust.doan.model.type.ERole;
import com.hust.doan.model.Role;
import com.hust.doan.model.User;
import com.hust.doan.payload.request.LoginRequest;
import com.hust.doan.payload.request.SignupRequest;
import com.hust.doan.payload.response.JwtResponse;
import com.hust.doan.payload.response.MessageResponse;
import com.hust.doan.service.imp.RoleService;
import com.hust.doan.service.imp.UserDetailsImpl;
import com.hust.doan.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MessageSource messageSource;


    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signupRequest,
                                      BindingResult result) {
        if (result.hasErrors()) {
            for (Object object : result.getAllErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    String message = messageSource.getMessage(fieldError, null);
                    System.out.println(message);
                }
            }
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error request"));
        }

//        roleService.save(new Role(ERole.ROLE_ADMIN));
//        roleService.save(new Role(ERole.ROLE_USER));

        User user = new User(signupRequest.getUsername(),
                passwordEncoder.encode(signupRequest.getPassword()),
                signupRequest.getFullName(),
                signupRequest.getEmail());

        List<String> strRoles = signupRequest.getRoles();

        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER);
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ROLE_ADMIN":
                        Role adminRole = roleService.findByName(ERole.ROLE_ADMIN);
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = roleService.findByName(ERole.ROLE_USER);
                        roles.add(userRole);
                        break;
                }
            });
        }
        user.setRoles(roles);
        userService.add(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getFullName(),
                roles
        ));
    }
}
