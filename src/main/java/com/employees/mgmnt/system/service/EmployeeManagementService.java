package com.employees.mgmnt.system.service;

import com.employees.mgmnt.system.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeManagementService {

    public List<EmployeeDTO> getAllEmployees();
    public ResponseEntity<?> addEmployee(EmployeeDTO employeeDTO);
    public void updateEmployee(EmployeeDTO employeeDTO);

}
