package com.employees.mgmnt.system.repository.entity;

import com.employees.mgmnt.system.model.Employee;
import com.employees.mgmnt.system.model.EmployeeState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long empId;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private int age;

  @Column(name = "phone_number")
  private String phoneNo;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private EmployeeState state;

  public Employee toEmployee() {
    return Employee.builder()
        .empId(empId)
        .name(name)
        .age(age)
        .state(state)
        .phoneNo(phoneNo)
        .build();
  }

  public static EmployeeEntity fromEmployee(Employee employee) {
    return EmployeeEntity.builder()
        .empId(employee.getEmpId())
        .name(employee.getName())
        .age(employee.getAge())
        .phoneNo(employee.getPhoneNo())
        .state(employee.getState())
        .build();
  }
}
