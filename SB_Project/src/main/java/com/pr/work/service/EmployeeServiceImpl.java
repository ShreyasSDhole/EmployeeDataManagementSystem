package com.pr.work.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.work.model.Employee;
import com.pr.work.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) 
	{
	    this.employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> optionalEmp = employeeRepository.findById(id);
		Employee employee = null;
		
		if(optionalEmp.isPresent())
		{
			employee = optionalEmp.get();
		}	
		else
		{	
			throw new RuntimeException("Employee not found of id : "+id);
		}
		return employee;
	}
	
	@Override
    public void deleteEmployeeById(int id) 
	{
        this.employeeRepository.deleteById(id);
    }
}
