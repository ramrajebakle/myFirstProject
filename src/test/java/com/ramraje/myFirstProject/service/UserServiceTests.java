package com.ramraje.myFirstProject.service;//package com.ramraje.myFirstProject.service;
//
//import com.ramraje.myFirstProject.repository.UserRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//@SpringBootTest
//public class UserServiceTests {
//    @Autowired
//    private UserRepository userRepository;
//
//    @ParameterizedTest
//    @ValueSource (strings = {
//            "ram",
//            "RAM",
//            "ramraje"
//    })
//    public void testFindByUsername(String username) {
//        assertNotNull(userRepository.findByUsername(username));
//    }
//    @ParameterizedTest
//    @CsvSource({
//            "1,2,3",
//            "2,3,5",
//            "4,6,10",
//            "1,1,3"
//    })
//    public  void  test(int a,int b,int expected){
//        assertEquals(expected,a+b);
//    }
//}
