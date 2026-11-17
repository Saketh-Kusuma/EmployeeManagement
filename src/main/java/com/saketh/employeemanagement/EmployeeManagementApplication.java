package com.saketh.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(EmployeeManagementApplication.class, args);
    }

}
