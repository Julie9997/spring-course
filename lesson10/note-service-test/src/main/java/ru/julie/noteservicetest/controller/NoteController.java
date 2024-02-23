package ru.julie.noteservicetest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.julie.noteservicetest.model.Note;
import ru.julie.noteservicetest.service.NotesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NotesService notesService;

    /**
     * список всех заметок
     * @return ответ с списком всех заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(notesService.findAll(), HttpStatus.OK);
    }

    /**
     * заметка по id
     * @param id
     * @return заметка
     */
    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable long id) {
        Optional<Note> note = notesService.findById(id);
        return note.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    /**
     * создане новой заметки
     * @param note новая заметка из тела запроса
     * @return созданная заметка
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(notesService.save(note), HttpStatus.CREATED);
    }

    /**
     * обновление заметки
     * @param note
     * @return обновленная заметка
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note, @PathVariable long id) {
        return new ResponseEntity<>(notesService.update(id, note), HttpStatus.OK);
    }

    /**
     * удаление заметки
     * @param id
     * @return статус выполнения
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable long id) {
        notesService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
