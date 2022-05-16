package com.technophiles.my_diary_app_mysql.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiResponse {
    private Object payload;
    private String message;
    private boolean isSuccessful;
    private int statusCode;
}
