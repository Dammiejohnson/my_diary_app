package com.technophiles.my_diary_app_mysql.services;

import com.technophiles.my_diary_app_mysql.exceptions.DiaryApplicationException;
import com.technophiles.my_diary_app_mysql.models.User;
import com.technophiles.my_diary_app_mysql.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {
    @Mock
    UserRepository userRepository;

    private UserService userService;

    @BeforeEach
     void setUp() {
        this.userService = new UserServiceImpl(userRepository);
    }
    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Test
    void testCanCreateAccount() throws DiaryApplicationException {
        String email = "testemail2gmail.com";
        String password = "password";
        when(userRepository.findUserByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(new User());
        userService.createAccount(email, password);
        verify(userRepository, times(1)).findUserByEmail(email);
        verify(userRepository, times(1)).save(userArgumentCaptor.capture());
        User user = userArgumentCaptor.getValue();
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
    }


    @AfterEach
    void tearDown(){
        userService = null;
    }
}
