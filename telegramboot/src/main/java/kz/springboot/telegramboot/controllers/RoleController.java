package kz.springboot.telegramboot.controllers;

import kz.springboot.telegramboot.entities.Roles;
import kz.springboot.telegramboot.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/v1/public/roles")

public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/read/all")
    public ResponseEntity<?> getAllRoles(){
        List<Roles> role;
        role = roleService.getAllRoles();
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping(value = "/addRole")
    public ResponseEntity<?> addRole(@RequestBody Roles role){
        roleService.addRole(role);
        return ResponseEntity.ok(role);
    }

    @GetMapping(value = "/read/one/{roleId}")
    public ResponseEntity<?> getRoleById(@PathVariable(name = "roleId") Integer roleId){
        Roles role = null;
        System.out.println("roleId " + roleId);
        if(roleId != null) {
            role = roleService.getRole(roleId.longValue());
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PutMapping (value = "/saverole")
    public  ResponseEntity<?> saveRole(@RequestBody Roles role){
        roleService.saveRole(role);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping(value = "/deleterole")
    public ResponseEntity<?> deleteRole(@RequestBody Roles role){
        Roles checkRoles = roleService.getRole(role.getId());
        if(checkRoles!=null){
            roleService.deleteRole(checkRoles);
            return ResponseEntity.ok(checkRoles);
        }
        return ResponseEntity.ok(role);
    }
}
