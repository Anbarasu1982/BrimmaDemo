package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="VEHICLE_DETAILS")
public class VehicleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private String vinNumber;
    private String modelName;
    private String modelYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", updatable = false, insertable = false)
    private Employee employee;

}
