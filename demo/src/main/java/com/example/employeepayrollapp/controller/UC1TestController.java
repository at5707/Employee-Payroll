package com.example.employeepayrollapp.controller;
import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/uc1")
public class UC1TestController {
	@PostMapping("/create")
    public EmployeePayrollData create(@RequestBody EmployeePayrollDTO dto) {
        // Simply return model with hardcoded ID to test mapping
        return new EmployeePayrollData(1, dto.getName(), dto.getSalary());
    }

    @GetMapping("/test")
    public String hello() {
        return "UC1 is running!";
    }
}
