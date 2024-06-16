package com.gabrielgomes.parking_control.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
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
public class ApartmentDTO {

    private Long id;

    @NotBlank(message = "The field 'number' cannot be blank.")
    @Size(max = 4, message = "The field 'number' must have at most {max} characters.")
    private String number;

    private OwnerDTO ownerDTO;
}
