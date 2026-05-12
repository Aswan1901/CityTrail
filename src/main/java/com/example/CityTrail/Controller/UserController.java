package com.example.CityTrail.Controller;


import java.util.List;

import com.example.CityTrail.Entity.User;
import com.example.CityTrail.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import com.example.CityTrail.DataNotFoundException;

@RestController
@RequestMapping("/user")
class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/show")
    List<User> all(){

        return userRepository.findAll();
    }

    @PostMapping("/save")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/{id}")
    User oneUser(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()-> new DataNotFoundException("User",id));
    }

    @PutMapping("/update/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
