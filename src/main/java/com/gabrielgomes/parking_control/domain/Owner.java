package com.gabrielgomes.parking_control.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owner")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner extends Person {

    public Owner(String name, String document) {
        super(name, document);
    }
}
