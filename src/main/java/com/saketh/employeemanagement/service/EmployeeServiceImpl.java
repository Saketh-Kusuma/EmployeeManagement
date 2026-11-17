package com.saketh.employeemanagement.service;

import com.saketh.employeemanagement.dao.IEmployeeDAO;
import com.saketh.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDAO employeeDAO;

    @Override
    public List<Employee> fetchEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
        try {
            desg1 = desg1.toUpperCase();
            desg2 = desg2.toUpperCase();
            desg3 = desg3.toUpperCase();
            List<Employee> employeeList = employeeDAO.getEmployeeByDesg(desg1, desg2, desg3);
            employeeList.sort((t1, t2) -> t1.getEmpNo().compareTo(t2.getEmpNo()));
            employeeList.forEach((emp) -> {
                emp.setGrossSalary(emp.getSalary() + (emp.getSalary() * 0.5));
                emp.setNetSalary(emp.getGrossSalary() - (emp.getGrossSalary() * 0.2));
            });
            return employeeList;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
