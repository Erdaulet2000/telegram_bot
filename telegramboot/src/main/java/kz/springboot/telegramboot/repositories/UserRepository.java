package kz.springboot.telegramboot.repositories;

import kz.springboot.telegramboot.entities.Roles;
import kz.springboot.telegramboot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Long> {
    Users getById(Long id);
    Users findByEmail(String email);
    List<Users> getAllByRoles(Roles role);
}
