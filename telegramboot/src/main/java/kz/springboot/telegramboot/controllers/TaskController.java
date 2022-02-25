package kz.springboot.telegramboot.controllers;

import kz.springboot.telegramboot.entities.Tasks;
import kz.springboot.telegramboot.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/v1/public/tasks")

public class TaskController {

    @Autowired
    private TaskService taskService;
    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/read/all")
    public ResponseEntity<?> getAllTasks(){
        List<Tasks> task;
        task = taskService.getAllTask();
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping(value = "/addTask")
    public ResponseEntity<?> addTask(@RequestBody Tasks task){
        taskService.addTask(task);
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/read/one/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable(name = "taskId") Integer taskId){
        Tasks task = null;
        System.out.println("taskId " + taskId);
        if(taskId != null) {
            task = taskService.getTask(taskId.longValue());
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping (value = "/savetask")
    public  ResponseEntity<?> saveTask(@RequestBody Tasks task){
        taskService.saveTask(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping(value = "/deletetask")
    public ResponseEntity<?> deleteTask(@RequestBody Tasks task){
        Tasks checkTasks = taskService.getTask(task.getId());
        if(checkTasks!=null){
            taskService.deleteTask(checkTasks);
            return ResponseEntity.ok(checkTasks);
        }
        return ResponseEntity.ok(task);
    }
}

