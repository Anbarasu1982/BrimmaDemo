package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Long> {

    List<VehicleDetails> findByEmployee(Employee employee);
}
