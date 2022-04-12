package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(Long empId) {
        Optional<Employee> emp = this.employeeRepository.findById(empId);
        return emp.isPresent() ? emp.get() : null;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
