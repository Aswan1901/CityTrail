package com.example.CityTrail.Controller;


import java.util.List;

import com.example.CityTrail.Entity.City;
import com.example.CityTrail.Repository.CityRepository;
import org.springframework.web.bind.annotation.*;
import com.example.CityTrail.DataNotFoundException;

@RestController
@RequestMapping("/city")
class CityController {

    private final CityRepository cityRepository;

    CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/show")
    List<City> all(){
        return cityRepository.findAll();
    }

    @PostMapping("/save")
    City newCity(@RequestBody City newCity){
        return cityRepository.save(newCity);
    }

    @GetMapping("/{id}")
    City oneCity(@PathVariable Long id){
        return cityRepository.findById(id).orElseThrow(()-> new DataNotFoundException("City",id));
    }

    @PutMapping("/update/{id}")
    City replaceCity(@RequestBody City newCity, @PathVariable Long id){
        return cityRepository.findById(id)
                .map(city -> {
                    city.setName(newCity.getName());
                    city.setDetails(newCity.getDetails());
                    return cityRepository.save(city);
                })
                .orElseGet(() -> {
                    return cityRepository.save(newCity);
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteCity(@PathVariable Long id){
        cityRepository.deleteById(id);
    }
}
