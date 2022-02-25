package kz.springboot.telegramboot.services.impl;

import kz.springboot.telegramboot.entities.Tasks;
import kz.springboot.telegramboot.repositories.TaskRepository;
import kz.springboot.telegramboot.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Tasks addTask(Tasks task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Tasks> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks getTask(Long id){
        return taskRepository.getById(id);
    }

    @Override
    public void  deleteTask(Tasks task){
        taskRepository.delete(task);
    }

    @Override
    public Tasks saveTask(Tasks task){
        return taskRepository.save(task);
    }

}
