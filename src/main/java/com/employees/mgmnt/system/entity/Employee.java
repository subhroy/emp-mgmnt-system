package com.employees.mgmnt.system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="age")
    private int age;
    @Column(name="phone_no")
    private String phoneNo;
    @Column(name="initial_state")
    private String initialState;
}


