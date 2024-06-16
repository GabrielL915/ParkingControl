package com.gabrielgomes.parking_control.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VEHICLE")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vehicle extends ParkingControlIdentifier {

    @Column(name = "license_plate", nullable = false, unique = true, length = 7)
    private String licensePlate;

    @Column(name = "brand", nullable = false, length = 40)
    private String brand;

    @Column(name = "model", nullable = false, length = 40)
    private String model;

    @Column(name = "color", nullable = false, length = 40)
    private String color;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
