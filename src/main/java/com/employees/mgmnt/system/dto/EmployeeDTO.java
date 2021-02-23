package com.employees.mgmnt.system.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    Integer empId;
    String firstName;
    Integer age;
    String phoneNo;
    String initialState;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", phoneNo='" + phoneNo + '\'' +
                ", initialState='" + initialState + '\'' +
                '}';
    }
}
