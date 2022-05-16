package com.technophiles.my_diary_app_mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Entry {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private  String text;

    @CreationTimestamp
    private LocalDateTime entryTime;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedTime;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    public Entry(String text) {
        this.text = text;
    }
}
