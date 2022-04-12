package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.VehicleDetails;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.VehicleDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VehicleDetailsService {

    private VehicleDetailsRepository vehicleDetailsRepositoryepository;
    private EmployeeRepository employeeRepository;

    public VehicleDetailsService(VehicleDetailsRepository repository, EmployeeRepository employeeRepository) {
        this.vehicleDetailsRepositoryepository = repository;
        this.employeeRepository = employeeRepository;
    }

    public List<VehicleDetails> getVehiclesDrivenByEmployee(Long empId) {
        Optional<Employee> empOptional = employeeRepository.findById(empId);
        return empOptional.isPresent() ? vehicleDetailsRepositoryepository.findByEmployee(empOptional.get()) : null;
    }

    public VehicleDetails saveVehicle(VehicleDetails vehicleDetails) {
        return vehicleDetailsRepositoryepository.save(vehicleDetails);
    }

    public void deleteVehicle(Long vehicleId) {
        vehicleDetailsRepositoryepository.deleteById(vehicleId);
    }
}
