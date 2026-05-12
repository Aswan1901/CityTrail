package com.example.CityTrail.Repository;

import com.example.CityTrail.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}