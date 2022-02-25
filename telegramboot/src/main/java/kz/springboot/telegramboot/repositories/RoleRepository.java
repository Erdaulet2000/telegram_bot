package kz.springboot.telegramboot.repositories;

import kz.springboot.telegramboot.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles getById(Long id);
}
