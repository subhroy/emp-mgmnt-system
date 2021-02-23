package com.employees.mgmnt.system;

import com.employees.mgmnt.system.service.EmployeeManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmpMgmntSystemApplicationTests {

	/*@Test
	void contextLoads() {
	}*/

	@Autowired
	EmployeeManagementService employeeManagementService;

	@Test
	public void testGetAllEmployee(){
		System.out.println("\n\n Result All Employees :: \n\n ");
		employeeManagementService.getAllEmployees().stream().forEach(employeeDTO -> {
			System.out.println(employeeDTO.toString());
		});
	}
}
