package com.example.demo.controller;

import com.example.demo.VehicleDetailsMapper;
import com.example.demo.model.VehicleDetails;
import com.example.demo.model.VehicleDetailsRequest;
import com.example.demo.service.VehicleDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/vehicledetail")
@Slf4j
public class VehicleDetailsController {

    VehicleDetailsService service;
    VehicleDetailsMapper mapper;



    public VehicleDetailsController(VehicleDetailsService service, VehicleDetailsMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{empId}")
    public List<VehicleDetails> getVehicles(@PathVariable("empId") Long empId)  {
        return service.getVehiclesDrivenByEmployee(empId);
    }


    @PostMapping
    public VehicleDetails saveVehicleDetails(@RequestBody VehicleDetailsRequest vehicleDetails) {
        VehicleDetails vehicleDetails1 = mapper.getVehicleDetails(vehicleDetails);
        return service.saveVehicle(vehicleDetails1);
    }

    @DeleteMapping(path = "/delete/{vehileId}")
    public String deleteVehicleDetails(@PathVariable Long vehicleId) {
        service.deleteVehicle(vehicleId);
        return "Vehicle Details Deleted Successfully " + vehicleId;
    }

}
