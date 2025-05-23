package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.service.IEmployeePayrollService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService payrollService;

    @GetMapping("/")
    public List<EmployeePayrollData> getEmployees() {
        return payrollService.getEmployeePayrollData();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployee(@PathVariable int id) {
        return payrollService.getEmployeePayrollDataById(id);
    }

    @PostMapping("/create")
    public EmployeePayrollData create(@Valid @RequestBody EmployeePayrollDTO dto) {
        return payrollService.createEmployeePayrollData(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData update(@PathVariable int id, @RequestBody EmployeePayrollDTO dto) {
        return payrollService.updateEmployeePayrollData(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        payrollService.deleteEmployeePayrollData(id);
    }
}
