package com.ramraje.myFirstProject.service;

import com.ramraje.myFirstProject.entity.User;
import com.ramraje.myFirstProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(User user) {
        try {

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
        } catch (Exception e) {
//            logger.info("asdfghjkl wertyuioklm nbvcxqwertyumn  dfghjktyj ertyuio ");
            log.error("Exception",e);
        }
    }
    public void saveAdmin(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER","ADMIN"));
            userRepository.save(user);
        } catch (Exception e) {
            log.error("Exception",e);
        }
    }
    public void saveUser(User user) {
        try {

            userRepository.save(user);
        } catch (Exception e) {
            log.error("Exception",e);
        }
    }
    public List<User> getAll() {

        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id) {

        return userRepository.findById(id);
    }
    public void deleteById(ObjectId id) {

        userRepository.deleteById(id);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
