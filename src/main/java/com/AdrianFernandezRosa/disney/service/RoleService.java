package com.AdrianFernandezRosa.disney.service;


import com.AdrianFernandezRosa.disney.entities.Role;

public interface RoleService {
    Role findByName(String name);
}
