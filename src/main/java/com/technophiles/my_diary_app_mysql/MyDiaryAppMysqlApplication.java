package com.technophiles.my_diary_app_mysql;

import com.technophiles.my_diary_app_mysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MyDiaryAppMysqlApplication {
//	@Autowired
//	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyDiaryAppMysqlApplication.class, args);
	}

//	@PostConstruct
//	void saveUsers(){
//
//	}



}
