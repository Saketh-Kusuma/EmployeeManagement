package com.saketh.employeemanagement.model;

import lombok.Data;

@Data
public class Employee {
    private Integer empNo;
    private String empName;
    private String job;
    private Double salary;
    private Integer deptNo;
    private Double grossSalary;
    private Double netSalary;
}
