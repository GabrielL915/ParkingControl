package com.gabrielgomes.parking_control.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parking_spot")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParkingSpot extends ParkingControlIdentifier {

    @Column(name = "number", nullable = false, unique = true, length = 4)
    private String number;

    @OneToOne
    @JoinColumn(name = "apartment_id", unique = true)
    private Apartment apartment;
}
