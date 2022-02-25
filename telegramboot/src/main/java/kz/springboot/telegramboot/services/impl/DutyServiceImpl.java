package kz.springboot.telegramboot.services.impl;

import kz.springboot.telegramboot.entities.Duties;
import kz.springboot.telegramboot.repositories.DutyRepository;
import kz.springboot.telegramboot.services.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DutyServiceImpl implements DutyService {

    @Autowired
    private DutyRepository dutyRepository;


    @Override
    public Duties addDuty(Duties duty) {
        return dutyRepository.save(duty);
    }


    @Override
    public Duties saveDuty(Duties duty) {
        return dutyRepository.save(duty);
    }

    @Override
    public Duties getDuty(Long id) {
        return dutyRepository.getById(id);
    }

    @Override
    public void deleteDuty(Duties duty) {
        dutyRepository.delete(duty);
    }

    @Override
    public List<Duties> getAllDuties() {
        return dutyRepository.findAll();
    }

}

