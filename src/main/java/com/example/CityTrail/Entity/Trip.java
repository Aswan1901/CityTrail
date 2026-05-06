package com.example.CityTrail.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private LocalDate startDate;
    private LocalDate endDate;
    private int rating;
    private String personalNote;

    protected Trip() {}

    public Trip(City city, LocalDate startDate, LocalDate endDate, int rating, String personalNote) {
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.personalNote = personalNote;
    }

    @Override
    public String toString() {
        return String.format(
                "Trip[id=%d, city='%s', startDate='%s', endDate='%s', rating='%d', personalNote='%s']",
                id,city, startDate, endDate, rating, personalNote);
    }

    public Long getId() {

        return id;
    }

    public City getCity() {

        return city;
    }

    public LocalDate getStartDate() {

        return startDate;
    }
    public LocalDate getEndDate() {

        return endDate;
    }

    public int getRating(){

        return rating;
    }

    public String getPersonalNote(){

        return personalNote;
    }

    public void setCity(City city){
        this.city = city;
    }

    public void setStartDate(LocalDate startDate){

        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate){

        this.endDate = endDate;
    }

    public void setRating(int rating){

        this.rating = rating;
    }

    public void setPersonalNote(String personalNote){

        this.personalNote = personalNote;
    }
}
