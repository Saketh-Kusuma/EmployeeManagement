package com.saketh.employeemanagement.dao;

import com.saketh.employeemanagement.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public List<Employee> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception;
}
