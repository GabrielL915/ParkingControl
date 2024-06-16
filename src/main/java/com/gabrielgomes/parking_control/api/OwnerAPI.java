package com.gabrielgomes.parking_control.api;

import com.gabrielgomes.parking_control.domain.Owner;
import com.gabrielgomes.parking_control.domain.dto.OwnerDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owners")
public class OwnerAPI extends CRUDAPI<Owner, Long, OwnerDTO> { }
