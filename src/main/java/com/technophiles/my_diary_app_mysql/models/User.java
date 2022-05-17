package com.technophiles.my_diary_app_mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Validated
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Email
    @Column(unique = true)
    private String email;

    @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true,fetch=FetchType.EAGER)
    private Set <Role> roles;

    private String password;

    @OneToMany(mappedBy="user",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY,
            orphanRemoval = true)
    private Set<Diary> diaries;



    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.diaries=new HashSet<>();
    }

    public User(String email, String password, RoleType roletype) {
        this.email = email;
        this.password = password;
        if(roles==null){
            roles= new HashSet<>();
        }
        roles.add(new Role(roletype));
    }

    @Override
    public String toString() {
        return String.format("id:%d\temail:%s", id,email);
    }

    public void addDiary(Diary diary){
        diaries.add(diary);
    }

    public void deleteDiary(Diary diary){
        diaries.remove(diary);
    }

    public void deleteAllDiaries(List<Diary> diariesList){
        diariesList.forEach(diaries::remove);
    }

    public void addRole(Role role){
        if (this.roles == null){
            this.roles = new HashSet<>();
        }
        roles.add(role);
    }

}