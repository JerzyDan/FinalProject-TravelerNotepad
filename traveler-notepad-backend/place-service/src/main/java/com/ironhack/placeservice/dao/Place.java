package com.ironhack.placeservice.dao;

import com.ironhack.placeservice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private Integer daysNeeded;
    private Status status;
    private Long countryId;

    public Place(String name, String city, Integer daysNeeded, Status status, Long countryId) {
        this.name = name;
        this.city = city;
        this.daysNeeded = daysNeeded;
        this.status = status;
        this.countryId = countryId;
    }

    public Place(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}
