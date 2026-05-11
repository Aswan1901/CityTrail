package com.example.CityTrail.Controller;


import java.util.List;

import com.example.CityTrail.Entity.Trip;
import com.example.CityTrail.Repository.TripRepository;
import org.springframework.web.bind.annotation.*;
import com.example.CityTrail.DataNotFoundException;

@RestController
@RequestMapping("/trip")
class TripController {

    private final TripRepository tripRepository;

    TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping("/show")
    List<Trip> all(){
        return tripRepository.findAll();
    }

    @PostMapping("/save")
    Trip newTrip(@RequestBody Trip newTrip){
        return tripRepository.save(newTrip);
    }

    @GetMapping("/{id}")
    Trip oneTrip(@PathVariable Long id){
        return tripRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Trip",id));
    }

    @PutMapping("/{id}")
    Trip replaceTrip(@RequestBody Trip newTrip, @PathVariable Long id){
        return tripRepository.findById(id)
                .map(trip -> {
                    trip.setCity(newTrip.getCity());
                    trip.setEndDate(newTrip.getEndDate());
                    trip.setRating(newTrip.getRating());
                    trip.setStartDate(newTrip.getStartDate());
                    trip.setPersonalNote(newTrip.getPersonalNote());
                    return tripRepository.save(trip);
                })
                .orElseGet(() -> {
                    return tripRepository.save(newTrip);
                });
    }

    @DeleteMapping("/{id}")
    void deleteTrip(@PathVariable Long id){
        tripRepository.deleteById(id);
    }
}
