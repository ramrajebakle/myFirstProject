package com.ramraje.myFirstProject.controller;

import com.ramraje.myFirstProject.api.response.WeatherResponse;
import com.ramraje.myFirstProject.entity.User;
import com.ramraje.myFirstProject.repository.UserRepository;
import com.ramraje.myFirstProject.service.UserService;
import com.ramraje.myFirstProject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
       User userInDb= userService.findByUsername(username);
       if(userInDb!=null) {
          userInDb.setUsername(user.getUsername());
          userInDb.setPassword(user.getPassword());
          userService.saveNewUser(userInDb);
       }
       return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        userRepository.deleteUserByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse=weatherService.getWeather("Mumbai");
        String greeting="";
        if(weatherResponse!=null) {
            greeting=", Weather feels like "+weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hii "+authentication.getName()+greeting, HttpStatus.OK);
    }
}
