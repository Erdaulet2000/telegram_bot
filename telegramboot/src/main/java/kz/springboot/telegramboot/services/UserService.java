package kz.springboot.telegramboot.services;

import kz.springboot.telegramboot.entities.Users;

import java.util.List;

public interface UserService {
    Users addUser(Users user);
    Users saveUser(Users user);
    Users getUser(Long id);
    void deleteUser(Users user);
    List<Users> getAllUsers();

    Users getUserByEmail(String email);
}
