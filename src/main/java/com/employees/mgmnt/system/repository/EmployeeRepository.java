package com.employees.mgmnt.system.repository;

import com.employees.mgmnt.system.repository.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
