package com.example.CityTrail.Repository;

import com.example.CityTrail.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}