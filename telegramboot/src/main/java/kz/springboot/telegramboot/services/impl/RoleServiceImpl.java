package kz.springboot.telegramboot.services.impl;

import kz.springboot.telegramboot.entities.Roles;
import kz.springboot.telegramboot.entities.Users;
import kz.springboot.telegramboot.repositories.RoleRepository;
import kz.springboot.telegramboot.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Roles addRole(Roles role) {
        return roleRepository.save(role);
    }


    @Override
    public Roles saveRole(Roles role) {
        return roleRepository.save(role);
    }

    @Override
    public Roles getRole(Long id) {
        return roleRepository.getById(id);
    }

    @Override
    public void deleteRole(Roles role) {
        roleRepository.delete(role);
    }

    @Override
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

}

