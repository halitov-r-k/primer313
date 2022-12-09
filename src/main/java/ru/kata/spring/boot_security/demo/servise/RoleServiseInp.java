package ru.kata.spring.boot_security.demo.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiseInp implements RoleServise {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiseInp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRole() {
        return roleRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);

    }
}
