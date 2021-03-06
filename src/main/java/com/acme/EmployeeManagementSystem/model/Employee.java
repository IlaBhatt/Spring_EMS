package com.acme.EmployeeManagementSystem.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@Setter
@EqualsAndHashCode
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;

    @NotBlank
    @NonNull
    private String empName;

    @NotBlank
    @NonNull
    private String empContact;

    @NotBlank
    @NonNull
    private String empDepartment;

    @NotBlank
    @NonNull
    private String empEmail;

    @NotBlank
    @NonNull
    private String empAddress;

    @NotBlank
    @NonNull
    private String empRole;

    public Employee() {
    }

    public Employee(String empName,String empContact,String empDepartment,String empEmail,String empAddress,String empRole)
    {
        this.empName=empName;
        this.empContact=empContact;
        this.empDepartment=empDepartment;
        this.empEmail=empEmail;
        this.empAddress=empAddress;
        this.empRole=empRole;
    }

}
