package com.example.CityTrail.Repository;

import com.example.CityTrail.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}