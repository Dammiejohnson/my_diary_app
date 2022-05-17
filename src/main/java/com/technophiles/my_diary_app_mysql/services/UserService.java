package com.technophiles.my_diary_app_mysql.services;

import com.technophiles.my_diary_app_mysql.dtos.UserDto;
import com.technophiles.my_diary_app_mysql.exceptions.DiaryApplicationException;
import com.technophiles.my_diary_app_mysql.models.Diary;
import com.technophiles.my_diary_app_mysql.models.User;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserService {
    UserDto createAccount(String email, String password) throws DiaryApplicationException;
    Diary addDiary(Long id, Diary diary) throws DiaryApplicationException;

    User findById(Long userId) throws DiaryApplicationException;
    User findUserByEmail(String email);

    boolean deleteUser(User user);

    List<User> getAllUsers();
}
