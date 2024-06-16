package com.gabrielgomes.parking_control.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDTO {

    private Long id;

    @NotBlank(message = "The field 'licensePlate' cannot be blank.")
    @Size(max = 7, message = "The field 'licensePlate' must have at most {max} characters.")
    private String licensePlate;

    @NotBlank(message = "The field 'brand' cannot be blank.")
    @Size(max = 40, message = "The field 'brand' must have at most {max} characters.")
    private String brand;

    @NotBlank(message = "The field 'model' cannot be blank.")
    @Size(max = 40, message = "The field 'model' must have at most {max} characters.")
    private String model;

    @NotBlank(message = "The field 'color' cannot be blank.")
    @Size(max = 40, message = "The field 'color' must have at most {max} characters.")
    private String color;

    @NotNull(message = "The field 'ownerDTO' cannot be null.")
    private OwnerDTO ownerDTO;
}
