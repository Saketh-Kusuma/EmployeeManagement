package com.saketh.employeemanagement.dao;

import com.saketh.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
    @Autowired
    private DataSource ds;
    private final String GET_EMPS_BY_DESGS = "SELECT EMPNO, ENAME, JOB, SALARY, DEPTNO FROM EMPLOYEES WHERE JOB IN (?,?,?)";

    @Override
    public List<Employee> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
        List<Employee> employeeList = null;
        try (
                //get pooled connection
                Connection con = ds.getConnection();
                //create prepared statement obj having the precompiled sql query
                PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);
        ) {   //set values to query params
            ps.setString(1, desg1);
            ps.setString(2, desg2);
            ps.setString(3, desg3);

            try (
                    //execute query
                    ResultSet rs = ps.executeQuery();
            ) {
                //process the result object
                employeeList = new ArrayList<>();
                while (rs.next()) {
                    //copy each record into java beans
                    Employee emp = new Employee();
                    emp.setEmpNo(rs.getInt(1));
                    emp.setEmpName(rs.getString(2));
                    emp.setJob(rs.getString(3));
                    emp.setSalary(rs.getDouble(4));
                    emp.setDeptNo(rs.getInt(5));
                    //add each java bean to list collection
                    employeeList.add(emp);
                }
            }

        } catch (SQLException e) {
            System.out.println("Some DB Problem, wait for some time");
            throw e;
        } catch (Exception e) {
            System.out.println("Some unknown problems wait for some time");
            throw e;
        }
        return employeeList;
    }
}
