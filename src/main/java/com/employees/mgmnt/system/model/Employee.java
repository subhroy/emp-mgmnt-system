package com.employees.mgmnt.system.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Employee {

  Long empId;
  String name;
  Integer age;
  String phoneNo;
  EmployeeState state;
}
