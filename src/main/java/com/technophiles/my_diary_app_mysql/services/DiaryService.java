package com.technophiles.my_diary_app_mysql.services;

import com.technophiles.my_diary_app_mysql.models.Diary;
import com.technophiles.my_diary_app_mysql.models.User;
public interface DiaryService {
    Diary createDiary(String title, User user);
}
