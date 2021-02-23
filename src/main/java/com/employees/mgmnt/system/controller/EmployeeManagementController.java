package com.employees.mgmnt.system.controller;

import com.employees.mgmnt.system.dto.EmployeeDTO;
import com.employees.mgmnt.system.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp/management/v1")
public class EmployeeManagementController {

    @Autowired
    EmployeeManagementService employeeManagementService;

    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployeeDetails(){
        return employeeManagementService.getAllEmployees();
    }

    @RequestMapping("/add/emp")
    @PostMapping
    public ResponseEntity<EmployeeDTO> addUserToDB(@RequestBody EmployeeDTO employeeDTO){
        employeeManagementService.addEmployee(employeeDTO);
        return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
    }
}
