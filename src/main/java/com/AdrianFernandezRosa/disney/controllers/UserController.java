package com.AdrianFernandezRosa.disney.controllers;

import com.AdrianFernandezRosa.disney.config.TokenProvider;
import com.AdrianFernandezRosa.disney.dto.AuthToken;
import com.AdrianFernandezRosa.disney.dto.LoginUser;
import com.AdrianFernandezRosa.disney.dto.UserDto;
import com.AdrianFernandezRosa.disney.entities.User;
import com.AdrianFernandezRosa.disney.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import javax.naming.AuthenticationException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class UserController {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final TokenProvider jwtTokenUtil;

    public UserController(AuthenticationManager authManager, UserService userService, PasswordEncoder encoder, TokenProvider jwtTokenUtil) {
        this.authManager = authManager;
        this.userService = userService;
        this.encoder = encoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/register")
    public User saveUser(@RequestBody UserDto user){

        return userService.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> autenticarse(@RequestBody LoginUser loginUser) throws AuthenticationException {


        System.out.println(loginUser.getPassword());
        final Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);

        return ResponseEntity.ok(new AuthToken(token));
    }


    public PasswordEncoder getEncoder() {
        return encoder;
    }
}
