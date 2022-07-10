package com.acme.EmployeeManagementSystem;
import com.acme.EmployeeManagementSystem.controllers.EmployeeController;
import com.acme.EmployeeManagementSystem.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

    @Autowired
    EmployeeController employeeController;

    @Test
    public void testCreateReadDelete()throws ValidationException {
        Employee employee = new Employee("Ila","7571034633","HR","ila@gmail.com","Delhi","E");
        Employee savedEmployee = employeeController.addEmployee(employee);

        Iterable<Employee> employeeList = employeeController.listEmployee();
        Assertions.assertThat(employeeList).first().hasFieldOrPropertyWithValue("empName", "Ila");

        employeeController.deleteEmployee(employee.getEmpID());
        Assertions.assertThat(employeeController.listEmployee()).isEmpty();

    }

    @Test(expected = ValidationException.class)
    public void checkingWrongUrl() {
        employeeController.enteredWrongUrl();

    }

}