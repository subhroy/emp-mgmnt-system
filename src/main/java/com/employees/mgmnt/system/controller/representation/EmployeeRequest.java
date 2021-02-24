package com.employees.mgmnt.system.controller.representation;

import com.employees.mgmnt.system.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
  String name;
  Integer age;
  String phoneNo;

  public Employee toEmployee() {
    return Employee.builder().name(name).age(age).phoneNo(phoneNo).build();
  }
}
