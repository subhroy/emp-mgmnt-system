package com.employees.mgmnt.system.controller;

import com.employees.mgmnt.system.controller.representation.EmployeeRequest;
import com.employees.mgmnt.system.controller.representation.EmployeeStateRequest;
import com.employees.mgmnt.system.model.Employee;
import com.employees.mgmnt.system.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp/management/v1/employees")
public class EmployeeManagementController {

  @Autowired EmployeeManagementService employeeManagementService;

  @GetMapping
  public List<Employee> getEmployeeDetails() {
    return employeeManagementService.getAllEmployees();
  }

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
    return new ResponseEntity<>(
        employeeManagementService.addEmployee(employeeRequest.toEmployee()), HttpStatus.OK);
  }

  @PatchMapping("/{empId}")
  public ResponseEntity<Employee> updateEmployee(
      @PathVariable long empId, @RequestBody EmployeeStateRequest stateRequest) {
    return new ResponseEntity<>(
        employeeManagementService.updateEmployeeState(empId, stateRequest), HttpStatus.OK);
  }
}
