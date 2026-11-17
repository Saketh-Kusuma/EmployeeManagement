package com.saketh.employeemanagement.controller;

import com.saketh.employeemanagement.dto.EmployeeSearchRequest;
import com.saketh.employeemanagement.model.Employee;
import com.saketh.employeemanagement.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> processEmployeeByDesg(@RequestBody EmployeeSearchRequest request) throws Exception {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.fetchEmployeeByDesg(request.getDesg1(), request.getDesg2(), request.getDesg3());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body("Database error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .status(500)
                    .body("Something went wrong: " + e.getMessage());
        }
        return ResponseEntity.ok(employeeList);
    }
}
