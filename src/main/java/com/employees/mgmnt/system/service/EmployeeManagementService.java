package com.employees.mgmnt.system.service;

import com.employees.mgmnt.system.controller.representation.EmployeeStateRequest;
import com.employees.mgmnt.system.model.Employee;

import java.util.List;

public interface EmployeeManagementService {

    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployeeState(Long empId, EmployeeStateRequest employeeStateRequest);

}
