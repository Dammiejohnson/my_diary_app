package com.technophiles.my_diary_app_mysql.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.technophiles.my_diary_app_mysql.models.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("user")
public class UserDto {
    private Long id;
    private String email;
    private Set<Diary> diaries;
}
