package ru.julie.notes_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String header;
    @Column(nullable = false)
    private String content;
    private LocalDateTime creationDate;

    public Note(String header, String content) {
        this.header = header;
        this.content = content;
    }
}
