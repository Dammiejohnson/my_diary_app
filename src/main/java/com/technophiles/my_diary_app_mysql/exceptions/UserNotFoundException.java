package com.technophiles.my_diary_app_mysql.exceptions;

public class UserNotFoundException extends DiaryApplicationException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
