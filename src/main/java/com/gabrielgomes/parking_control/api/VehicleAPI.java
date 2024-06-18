package com.gabrielgomes.parking_control.api;

import com.gabrielgomes.parking_control.domain.Vehicle;
import com.gabrielgomes.parking_control.domain.dto.VehicleDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleAPI extends CRUDAPI<Vehicle, Long, VehicleDTO> {
}
