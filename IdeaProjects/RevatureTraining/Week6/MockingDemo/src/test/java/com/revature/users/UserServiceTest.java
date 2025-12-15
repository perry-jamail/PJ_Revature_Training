package com.revature.users;

import com.revature.users.dao.UserRepository;
import com.revature.users.model.User;
import com.revature.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock // creates the mocked UserRepository
    private UserRepository repository;
    @InjectMocks // Injects the mocked UserRepository into UserService
    private UserService service;
    private User existingUser;
    private User newUser;

    @BeforeEach
    public void setUp() {
        existingUser = new User(1L, "Harper", "harperjamail@gmail.com");
        newUser = new User(null, "Amara", "amarajamail@gmail.com");
    }

    @Test
    public void testUserById_positive() {
        // Arrange
        when(repository.findById(1L)).thenReturn(existingUser);

        // Act
        User foundUser = service.getUserById(1L);

        // Assert
        assertEquals("Harper", foundUser.getName());
    }

    // Assignment: Write testUserById_negative()
    @Test
    public void testUserById_negative() {
        // Arrange
        when(repository.findById(1L)).thenReturn(null);

        // Act
        User foundUser = service.getUserById(1L);

        // Assert
        assertNull(foundUser);
    }

    // Assignment: Test successful registration
    @Test
    public void testRegister_positive() {
        //when(repository.register(newUser)).thenReturn(true);

        Boolean result = service.register(newUser);

        assertEquals(true, result);
    }

    // Assignment: Test registration when user already exists
    @Test
    public void testRegister_negative() {
        when(repository.register(existingUser)).thenReturn(false);

        Boolean result = service.register(existingUser);

        assertEquals(false, result);
    }
}
