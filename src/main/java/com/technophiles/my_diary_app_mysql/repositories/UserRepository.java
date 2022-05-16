package com.technophiles.my_diary_app_mysql.repositories;

import com.technophiles.my_diary_app_mysql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
