package kz.springboot.telegramboot.repositories;

import kz.springboot.telegramboot.entities.Duties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface DutyRepository  extends JpaRepository<Duties, Long> {
    Duties getById(Long id);
}
