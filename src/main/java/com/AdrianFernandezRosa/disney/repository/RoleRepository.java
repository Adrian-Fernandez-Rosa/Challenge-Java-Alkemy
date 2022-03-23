package com.AdrianFernandezRosa.disney.repository;


import com.AdrianFernandezRosa.disney.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}