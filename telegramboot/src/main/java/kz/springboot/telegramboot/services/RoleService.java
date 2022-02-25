package kz.springboot.telegramboot.services;

import kz.springboot.telegramboot.entities.Roles;

import java.util.List;

public interface RoleService {

    Roles addRole(Roles role);
    Roles saveRole(Roles role);
    Roles getRole(Long id);
    void deleteRole(Roles checkRoles);
    List<Roles> getAllRoles();
}
