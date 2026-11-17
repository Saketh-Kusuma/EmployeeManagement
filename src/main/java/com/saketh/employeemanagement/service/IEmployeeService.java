package com.saketh.employeemanagement.service;

import com.saketh.employeemanagement.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> fetchEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception;
}
