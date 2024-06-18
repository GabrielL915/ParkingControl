package com.gabrielgomes.parking_control.api;

import com.gabrielgomes.parking_control.domain.Apartment;
import com.gabrielgomes.parking_control.domain.dto.ApartmentDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apartment")
public class ApartmentAPI extends CRUDAPI<Apartment, Long, ApartmentDTO> {
}
