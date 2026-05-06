package com.example.CityTrail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String details;

    protected City() {}

    public City(String name, String country, String details) {
        this.name = name;
        this.country = country;
        this.details = details;
    }

    @Override
    public String toString() {
        return String.format(
                "City[id=%d, name='%s', country='%s', details='%s']",
                id, name, country, details);
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getCountry() {

        return country;
    }

    public String getDetails() {

        return details;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setCountry(String country){

        this.country = country;
    }

    public void setDetails(String details){
        this.details = details;
    }
}
