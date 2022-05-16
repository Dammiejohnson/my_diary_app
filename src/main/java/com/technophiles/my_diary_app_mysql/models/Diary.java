package com.technophiles.my_diary_app_mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Validated
@NoArgsConstructor
@JsonIgnoreProperties("user")
public class Diary {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max= 255)
    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "diary",
                        orphanRemoval = true,
                        fetch = FetchType.LAZY,
                        cascade = CascadeType.ALL)
    private Set<Entry> entries;

    @Override
    public String toString() {
        return String.format("id:%d\ttitle:%s", id, title);
    }

    public Diary(String title) {
        this.title = title;
    }
}
