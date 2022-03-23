package com.AdrianFernandezRosa.disney.service;



import com.AdrianFernandezRosa.disney.dto.UserDto;
import com.AdrianFernandezRosa.disney.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDto user) throws Exception;

    User findOne(String email);
}
