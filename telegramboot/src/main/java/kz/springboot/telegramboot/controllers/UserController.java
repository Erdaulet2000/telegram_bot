package kz.springboot.telegramboot.controllers;

import kz.springboot.telegramboot.entities.Users;
import kz.springboot.telegramboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/v1/public/users")

public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/read/all")
    public ResponseEntity<?> getAllUsers(){
        List<Users> user;
        user = userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<?> addUser(@RequestBody Users user){
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/read/one/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "userId") Integer userId){
        Users user = null;
        System.out.println("userId " + userId);
        if(userId != null) {
            user = userService.getUser(userId.longValue());
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping (value = "/saveuser")
    public  ResponseEntity<?> saveUser(@RequestBody Users user){
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/deleteuser")
    public ResponseEntity<?> deleteUser(@RequestBody Users user){
        Users checkUsers = userService.getUser(user.getId());
        if(checkUsers!=null){
            userService.deleteUser(checkUsers);
            return ResponseEntity.ok(checkUsers);
        }
        return ResponseEntity.ok(user);
    }
}

