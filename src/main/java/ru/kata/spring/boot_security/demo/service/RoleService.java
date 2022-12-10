package ru.kata.spring.boot_security.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepo, RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public Set<Role> findRollsById(String roleId) {
        Set<Role> roles = new HashSet<>();
        for (Role role : roleRepository.findAll()) {
            if (roleId.contains(role.getId().toString())) {
                roles.add(role);
            }
        }
        return roles;
    }

    public Role getRole(String name) {
        return roleRepository.findRoleByName(name);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();

    }
}