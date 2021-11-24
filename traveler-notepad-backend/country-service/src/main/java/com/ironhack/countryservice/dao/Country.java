package com.ironhack.countryservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String officialLanguage;
    private String climate;
    private String area;

    public Country (String name) {
        setName(name);
    }

    public Country(String name, String officialLanguage, String climate, String area) {
        this.name = name;
        this.officialLanguage = officialLanguage;
        this.climate = climate;
        this.area = area;
    }
}
