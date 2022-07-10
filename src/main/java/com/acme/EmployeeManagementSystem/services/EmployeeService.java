package com.acme.EmployeeManagementSystem.services;

import com.acme.EmployeeManagementSystem.model.Employee;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService extends CrudRepository<Employee, Integer> { //here integer is primary key

}
