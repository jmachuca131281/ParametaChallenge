package com.example.parameta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ArrayList<EmployeeEntity> findEmployee(){
        return employeeService.findEmployee();
    }

    @GetMapping(path="/{id}")
    public Object findEmployeeById(@PathVariable("id") String id) {
        return this.employeeService.findEmployeeById(id);
    }

    @PostMapping()
    public String saveEmployee(@RequestBody EmployeeEntity u){
        LocalDate actualDate = LocalDate.now(), birthDate = u.birth_date;
        Period period = Period.between(birthDate, actualDate);
        int y = Math.abs(period.getYears());
        int m = Math.abs(period.getMonths());
        int d = Math.abs(period.getDays());
        String r = "";

        if(u.getName().isEmpty() || u.getLastName().isEmpty() || u.getJobPosition().isEmpty() || u.getIdDocument().isEmpty() || u.getDocumentType().isEmpty() ){
            r = "{\"error\": \"All fields should be different from null\"}";
        } else if(y >= 18){
            this.employeeService.saveEmployee(u);
            r = "{\"response\": \"Actual age: Year: " + y + ", Month: "+m+", Days: "+d+"\", \"Vinculation\": \"Years: "+y+", Month: "+m+", Days: "+d+"\"}";
        } else{
            r = "{\"error\": \"User should be older than > 18, tray again\"}";
        }
        return r;
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") String id){
        boolean ok = this.employeeService.deleteEmployeeById(id);
        if (ok){
            return "User with id: " + id + " removed";
        }else{
            return "Unregistered employee " + id;
        }
    }
}