package com.example.employeepayrollapp.service;
import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeList.stream().filter(emp -> emp.getId() == empId).findFirst().orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO dto) {
        EmployeePayrollData newEmp = new EmployeePayrollData(idCounter.getAndIncrement(), dto.getName(), dto.getSalary());
        employeeList.add(newEmp);
        return newEmp;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto) {
        EmployeePayrollData emp = getEmployeePayrollDataById(empId);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
        }
        return emp;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeeList.removeIf(emp -> emp.getId() == empId);
    }
}
