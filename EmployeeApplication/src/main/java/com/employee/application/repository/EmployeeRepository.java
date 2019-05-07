package com.employee.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.application.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	

}
