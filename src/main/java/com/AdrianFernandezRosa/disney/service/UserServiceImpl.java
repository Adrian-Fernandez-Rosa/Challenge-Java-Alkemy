package com.AdrianFernandezRosa.disney.service;

import com.AdrianFernandezRosa.disney.Exception.EmailAlreadyExistsException;
import com.AdrianFernandezRosa.disney.dto.UserDto;
import com.AdrianFernandezRosa.disney.entities.Role;
import com.AdrianFernandezRosa.disney.entities.User;

import com.AdrianFernandezRosa.disney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

     @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(UserDto user) {

        User nUser = user.getUserFromDto();
        if(userRepository.existsByEmail(nUser.getEmail()))
            throw new EmailAlreadyExistsException("Email ya existente");

        nUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        nUser.setRoles(roleSet);

        return userRepository.save(nUser);

    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new EmailAlreadyExistsException("Password o email invalido");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+ role.getName()));
        });
        return authorities;
    }

    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }


}
