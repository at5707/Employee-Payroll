package com.example.employeepayrollapp.dto;
import lombok.Data;
@Data
public class EmployeePayrollDTO {
	private String name;
	private long salary;
	public EmployeePayrollDTO() {}
	public EmployeePayrollDTO(String name,long salary) {
		this.name=name;
		this.salary=salary;
	}
	public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getSalary() { return salary; }
    public void setSalary(long salary) { this.salary = salary; }
}