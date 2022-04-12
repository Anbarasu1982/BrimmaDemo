package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.model.VehicleDetails;
import com.example.demo.model.VehicleDetailsRequest;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Component;

@Component
public class VehicleDetailsMapper {

    EmployeeService empService;

    public VehicleDetailsMapper(EmployeeService empService) {
        this.empService = empService;
    }

    public VehicleDetails getVehicleDetails(VehicleDetailsRequest request) {
        Employee emp = empService.getEmployee(request.getEmployeeId());
        return VehicleDetails.builder()
                .vinNumber(request.getVinNumber())
                .modelName(request.getModelName())
                .modelYear(request.getModelYear())
                .employee(emp)
                .build();
    }
}
