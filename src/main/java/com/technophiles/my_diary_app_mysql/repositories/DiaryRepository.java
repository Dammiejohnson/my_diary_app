package com.technophiles.my_diary_app_mysql.repositories;

import com.technophiles.my_diary_app_mysql.models.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
