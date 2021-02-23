package com.employees.mgmnt.system.repository;

import com.employees.mgmnt.system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
