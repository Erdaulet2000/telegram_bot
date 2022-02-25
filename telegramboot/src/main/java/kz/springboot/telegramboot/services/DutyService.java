package kz.springboot.telegramboot.services;

import kz.springboot.telegramboot.entities.Duties;

import java.util.List;

public interface DutyService {

    Duties addDuty(Duties duty);
    Duties saveDuty(Duties duty);
    Duties getDuty(Long id);
    void deleteDuty(Duties checkDuties);
    List<Duties> getAllDuties();
}
