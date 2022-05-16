package com.technophiles.my_diary_app_mysql.services;

import com.technophiles.my_diary_app_mysql.models.Diary;
import com.technophiles.my_diary_app_mysql.models.User;
import com.technophiles.my_diary_app_mysql.repositories.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;
    @Override
    public Diary createDiary(String title, User user) {
        Diary diary = new Diary(title);
        diary.setUser(user);
        return diaryRepository.save(diary);
    }
}
