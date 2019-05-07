package com.employee.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.application.model.Employee;
import com.employee.application.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;

	/* save to an employee */
	public Employee save(Employee emp) {
		return empRepository.save(emp);
	}

	/* search all employee */

	public List<Employee> findAll() {
		return empRepository.findAll();
	}

	/* get an employee */

	public Optional<Employee> findOne(Long empid) {
		return empRepository.findById(empid);
	}
	
	/**/
	
	public Employee update(Long id) {
		return empRepository.getOne(id);
	}

	/* Delete An Employee */
	public void delete(Employee emp) {
		empRepository.delete(emp);
	}

}
