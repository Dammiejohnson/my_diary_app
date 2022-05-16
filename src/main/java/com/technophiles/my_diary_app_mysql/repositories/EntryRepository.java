package com.technophiles.my_diary_app_mysql.repositories;

import com.technophiles.my_diary_app_mysql.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
