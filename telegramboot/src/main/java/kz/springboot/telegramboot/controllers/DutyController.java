package kz.springboot.telegramboot.controllers;

import kz.springboot.telegramboot.entities.Duties;
import kz.springboot.telegramboot.services.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/v1/public/duty")

public class DutyController {

    @Autowired
    private DutyService dutyService;


    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/read/all")
    public ResponseEntity<?> getAllDuties(){
        List<Duties> duty;
        duty = dutyService.getAllDuties();
        return new ResponseEntity<>(duty, HttpStatus.OK);
    }

    @PostMapping(value = "/addDuty")
    public ResponseEntity<?> addDuty(@RequestBody Duties duty){
        dutyService.addDuty(duty);
        return ResponseEntity.ok(duty);
    }

    @GetMapping(value = "/read/one/{dutyId}")
    public ResponseEntity<?> getDutyById(@PathVariable(name = "dutyId") Integer dutyId){
        Duties duty = null;
        if(dutyId != null) {
            duty = dutyService.getDuty(dutyId.longValue());
        }
        return new ResponseEntity<>(duty, HttpStatus.OK);
    }

    @PutMapping (value = "/saveduty")
    public  ResponseEntity<?> saveDuty(@RequestBody Duties duty){
        dutyService.saveDuty(duty);
        return ResponseEntity.ok(duty);
    }

    @DeleteMapping(value = "/deleteduty")
    public ResponseEntity<?> deleteDuty(@RequestBody Duties duty){
        Duties checkDuties = dutyService.getDuty(duty.getId());
        if(checkDuties!=null){
            dutyService.deleteDuty(checkDuties);
            return ResponseEntity.ok(checkDuties);
        }
        return ResponseEntity.ok(duty);
    }
}
