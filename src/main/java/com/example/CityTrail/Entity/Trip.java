package com.example.CityTrail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private int rating;
    private String personalNote;

    protected Trip() {}

    public Trip(String city, LocalDate startDate, LocalDate endDate, int rating, String personalNote) {
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

    public String getCity() {
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

    public void setCity(String city){
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
