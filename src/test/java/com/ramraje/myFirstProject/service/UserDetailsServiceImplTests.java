//package com.ramraje.myFirstProject.service;//package com.ramraje.myFirstProject.service;
//
//import com.ramraje.myFirstProject.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//public class UserDetailsServiceImplTests {
//    @InjectMocks
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Mock
//    private UserRepository userRepository;
//    @BeforeEach
//    void setUp() {
//
//    }
//    @Test
//    void loadUserByUsernameTest() {
////        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn( User.builder().username("ram").password("dhjfejhf").roles(String.valueOf(new ArrayList<>())).build());
//        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("ram").password("gddfdhd").build());
//        UserDetails user= userDetailsService.loadUserByUsername("ram");
//        Assertions.assertNotNull(user);
//    }
//}
