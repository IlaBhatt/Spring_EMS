package com.acme.EmployeeManagementSystem;

import com.acme.EmployeeManagementSystem.controllers.EmployeeController;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

	@Autowired
	EmployeeController employeeController;
	@Test
	void contextLoads() {
		Assert.assertNotNull(employeeController);
	}

}
