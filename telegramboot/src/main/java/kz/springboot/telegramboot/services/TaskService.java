package kz.springboot.telegramboot.services;

import kz.springboot.telegramboot.entities.Tasks;

import java.util.List;

public interface TaskService {
    Tasks addTask(Tasks task);
    List<Tasks> getAllTask();
    Tasks getTask(Long id);
    void deleteTask(Tasks task);
    Tasks saveTask(Tasks task);
}
