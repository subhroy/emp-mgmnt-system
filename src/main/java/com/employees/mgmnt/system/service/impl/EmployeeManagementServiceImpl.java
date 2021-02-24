package com.employees.mgmnt.system.service.impl;

import com.employees.mgmnt.system.controller.representation.EmployeeStateRequest;
import com.employees.mgmnt.system.exceptions.NotFoundException;
import com.employees.mgmnt.system.model.Employee;
import com.employees.mgmnt.system.model.EmployeeState;
import com.employees.mgmnt.system.repository.EmployeeRepository;
import com.employees.mgmnt.system.repository.entity.EmployeeEntity;
import com.employees.mgmnt.system.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

  @Autowired EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getAllEmployees() {
    List<Employee> empList =
        employeeRepository.findAll().stream()
            .map(EmployeeEntity::toEmployee)
            .collect(Collectors.toList());
    return Objects.requireNonNullElse(empList, Collections.emptyList());
  }

  @Override
  public Employee addEmployee(Employee employee) {
    employee = employee.toBuilder().state(EmployeeState.ADDED).build();
    return save(employee);
  }

  @Override
  public Employee updateEmployeeState(Long empId, EmployeeStateRequest employeeState) {
    Employee employee =
        employeeRepository
            .findById(empId)
            .orElseThrow(
                () -> new NotFoundException(String.format("Employee %d not found!", empId)))
            .toEmployee();

    employee = employee.toBuilder().state(employeeState.getState()).build();
    return save(employee);
  }

  private Employee save(Employee employee) {
    return employeeRepository.save(EmployeeEntity.fromEmployee(employee)).toEmployee();
  }
}
