package com.project.library.api.services;

import com.project.library.api.domain.User;
import com.project.library.api.repositories.UserRepository;
import com.project.library.api.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestSuite {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testGetAllUsers() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        User user2 = new User("Daniella", "Hammer", LocalDate.of(2015, 2, 12));
        userRepository.save(user1);
        userRepository.save(user2);
        //When
        List<User> usersList = userService.getAllUsers();
        //Then
        Assert.assertEquals(2, usersList.size());
        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testGetUserById() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        User user2 = new User("Daniella", "Hammer", LocalDate.of(2015, 2, 12));
        userRepository.save(user1);
        userRepository.save(user2);
        Long userId = user1.getId();
        //When
        User testUser = userService.getUserById(userId).get();
        //Then
        Assert.assertEquals("Snow", testUser.getLastName());
        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testSaveUser() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        User user2 = new User("Daniella", "Hammer", LocalDate.of(2015, 2, 12));
        //When
        userService.saveUser(user1);
        userService.saveUser(user2);
        //Then
        Assert.assertEquals(2, userService.getAllUsers().size());
        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testDeleteUserById() {
        //Given
        User user1 = new User("John", "Snow", LocalDate.of(2010, 4, 5));
        User user2 = new User("Daniella", "Hammer", LocalDate.of(2015, 2, 12));
        userRepository.save(user1);
        userRepository.save(user2);
        Long user1Id = user1.getId();
        //When
        userService.deleteUserById(user1Id);
        //Then
        Assert.assertEquals(1, userService.getAllUsers().size());
        //CleanUp
        userRepository.deleteAll();
    }
}
