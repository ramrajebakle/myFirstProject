package com.ramraje.myFirstProject.controller;

import com.ramraje.myFirstProject.entity.User;
import com.ramraje.myFirstProject.service.EmailService;
import com.ramraje.myFirstProject.service.UserDetailsServiceImpl;
import com.ramraje.myFirstProject.service.UserService;
import com.ramraje.myFirstProject.utilis.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Slf4j
public class PublicController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    AuthenticationManager authenticationManeger;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
   @Autowired
   private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public void createUser(@RequestBody User user) {
        userService.saveNewUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        try {
           authenticationManeger.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occurred while createAuthenticationToken",e);
            return new ResponseEntity<>("Incorrect username or Password",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/health-check")
    public String healthCheck() {
//        emailService.sendEmail(
//                "bakleramraje@gmail.com",
//                "Testing Java main Sender",
//                "Hii Buddy, How are you?"
//        );
        return "OK";
    }
}
