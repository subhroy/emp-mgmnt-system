package com.employees.mgmnt.system.impl;

import com.employees.mgmnt.system.EmployeeState;
import com.employees.mgmnt.system.dto.EmployeeDTO;
import com.employees.mgmnt.system.entity.Employee;
import com.employees.mgmnt.system.repository.EmployeeRepository;
import com.employees.mgmnt.system.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    EmployeeRepository employeeRepository;




    @Override
    public  List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
        employeeRepository.findAll().forEach(employees -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();

            employeeDTO.setEmpId(employees.getEmpId());
            employeeDTO.setFirstName(employees.getFirstName());
            employeeDTO.setAge(employees.getAge());
            employeeDTO.setPhoneNo(employees.getPhoneNo());
            employeeDTO.setInitialState(employees.getInitialState());

            empList.add(employeeDTO);
        });
        return empList;
    }

    @Override
    public ResponseEntity<?> addEmployee(EmployeeDTO employeeDTO) {
        Employee employeeObj = new Employee();
        employeeObj.setFirstName(employeeDTO.getFirstName());
        employeeObj.setAge(employeeDTO.getAge());
        employeeObj.setPhoneNo(employeeDTO.getPhoneNo());
        employeeObj.setInitialState(EmployeeState.Added.toString());

        employeeRepository.save(employeeObj);
        return ResponseEntity.ok(employeeObj);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {

    }
}
