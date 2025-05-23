package com.example.employeepayrollapp.dto;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {
	@NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Name must start with capital and have at least 3 characters")
	private String name;
	@Min(value = 500, message = "Salary must be at least 500")
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