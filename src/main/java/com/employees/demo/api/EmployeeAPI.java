package com.employees.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.demo.model.Employee;
import com.employees.demo.model.HourlyEmployee;
import com.employees.demo.model.Manager;
import com.employees.demo.model.SalariedEmployee;

@RestController
public class EmployeeAPI {

	List<Employee> employees = new ArrayList<>();

	@PostMapping("/employees")
	public List<Employee> createEmployees() {
		employees = new ArrayList<>();
		employees.addAll(retrieveHourlyEmployees());
		employees.addAll(retrieveSalariedEmployees());
		employees.addAll(retrieveManagers());
		return employees;
	}

	public List<Employee> retrieveHourlyEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			employees.add(new HourlyEmployee(i + 1, "Employee " + (i + 1), "Address " + (i + 1)));
		}
		return employees;
	}

	public List<Employee> retrieveSalariedEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 10; i < 20; i++) {
			employees.add(new SalariedEmployee(i + 1, "Employee " + (i + 1), "Address" + (i + 1)));
		}
		return employees;
	}

	public List<Employee> retrieveManagers() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 20; i < 30; i++) {
			employees.add(new Manager(i + 1, "Employee " + (i + 1), "Address" + (i + 1)));
		}
		return employees;
	}

	@GetMapping("/employees")
	public List<Employee> retrieveEmployees() {
		return this.employees;
	}

	@PostMapping("/takeVacation/{id}/{days}")
	public void takeAction(@PathVariable("id") Integer id, @PathVariable("days") Integer days) {
		Optional<Employee> optionalEmployee = this.employees.stream().filter(x -> x.getId() == id.intValue()).findAny();
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			employee.TakeVacation(days);
		}
	}

	@PostMapping("/work/{id}/{days}")
	public void work(@PathVariable("id") Integer id, @PathVariable("days") Integer days) {
		Optional<Employee> optionalEmployee = this.employees.stream().filter(x -> x.getId() == id.intValue()).findAny();
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			employee.Work(days);
		}
	}

}
