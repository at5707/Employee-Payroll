package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/uc1")
public class UC1TestController {

    private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @PostMapping("/create")
    public EmployeePayrollData create(@RequestBody EmployeePayrollDTO dto) {
        EmployeePayrollData employee = new EmployeePayrollData(idCounter.getAndIncrement(), dto.getName(), dto.getSalary());
        employeeList.add(employee);
        return employee;
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getById(@PathVariable int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);
        return removed ? "Deleted successfully!" : "Employee not found!";
    }

    @GetMapping("/test")
    public String hello() {
        return "UC1 is running!";
    }
}
