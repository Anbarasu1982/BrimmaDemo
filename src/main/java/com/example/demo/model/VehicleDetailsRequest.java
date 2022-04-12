package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDetailsRequest {
    private String vinNumber;
    private String modelName;
    private String modelYear;
    private Long employeeId;
}
