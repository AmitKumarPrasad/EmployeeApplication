package com.employee.application.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.application.model.Employee;
import com.employee.application.service.EmployeeService;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
	private EmployeeService empDao;
	
	/* To Save an Employee*/
	@PostMapping("/addEmployee")
	public Employee addEmployee(@Valid @RequestBody Employee emp) {
		return empDao.save(emp);
	}
	
	/* Find All Employee*/
	@GetMapping("/findAllEmp")
	public List<Employee> findAllEmp(){
		return empDao.findAll();
	}
	/*Find By Id*/
	@GetMapping("/findById/{id}")
	public ResponseEntity<Optional<Employee>> findById(@PathVariable(value="id")Long id){
	Optional<Employee> emp = empDao.findOne(id);
	if(emp==null) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().body(emp);
	}
	
	
	/*Update an Employee By Id*/
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")Long id,@Valid @RequestBody Employee empDetails){
		Employee emp = empDao.update(id);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee update = empDao.save(emp);
		return ResponseEntity.ok().body(update);
	}
	
	/* Delete An Employee*/
	/*public ResponseEntity<Optional<Employee>> deleteEmployee(@PathVariable(value="id")Long id){
		Optional<Employee> emp = empDao.findOne(id);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		empDao.delete(emp);*/
	
	

}
