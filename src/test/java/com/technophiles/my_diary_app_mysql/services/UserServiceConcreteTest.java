package com.technophiles.my_diary_app_mysql.services;

import com.technophiles.my_diary_app_mysql.dtos.UserDto;
import com.technophiles.my_diary_app_mysql.exceptions.DiaryApplicationException;
import com.technophiles.my_diary_app_mysql.models.User;
import com.technophiles.my_diary_app_mysql.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UserServiceConcreteTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testThatCanDeleteUser() throws DiaryApplicationException {
       UserDto userDto = userService.createAccount("new-user@gmail.com", "password");
       User user = userRepository.findById(userDto.getId()).get();
       userService.deleteUser(user);
        Optional<User> deletedUser = userRepository.findById(userDto.getId());
        assertThat(deletedUser).isEqualTo(Optional.empty());

    }
}
