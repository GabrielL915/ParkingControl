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
public class OwnerDTO {

    private Long id;

    @NotBlank(message = "The field 'name' cannot be blank.")
    @Size(max = 60, message = "The field 'name' must have at most {max} characters.")
    private String name;

    @NotBlank(message = "The field 'document' cannot be blank.")
    @Size(max = 15, message = "The field 'document' must have at most {max} characters.")
    private String document;
}
