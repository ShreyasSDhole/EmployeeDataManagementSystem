package com.pr.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pr.work.model.Employee;
import com.pr.work.service.EmployeeService;


@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("list_Employees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "AddEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable int id, Model model) 
	{
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "UpdateEmployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) 
	{
        // call delete employee method 
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
	
	
}
