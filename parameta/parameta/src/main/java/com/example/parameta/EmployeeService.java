package com.example.parameta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<EmployeeEntity> findEmployee(){
        return (ArrayList<EmployeeEntity>) employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> findEmployeeById(String id){
        return employeeRepository.findById(id);
    }

    public EmployeeEntity saveEmployee(EmployeeEntity e){
        return employeeRepository.save(e);
    }

    public boolean deleteEmployeeById(String id) {
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}