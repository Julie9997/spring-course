package ru.julie.noteservicetest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julie.noteservicetest.model.Note;
import ru.julie.noteservicetest.repository.NotesRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotesService {

    private final NotesRepository notesRepository;

    /**
     * получение списка всех заметок
     * @return список заметок
     */
    public List<Note> findAll() {
        return notesRepository.findAll();
    }

    /**
     * поиск заметки по id
     * @param id
     * @return заметка
     */
    public Optional<Note> findById(Long id) {
        return notesRepository.findById(id);
    }

    /**
     * создание заметки
     * @param note
     * @return созданная заметка
     */
    public Note save(Note note) {
        note.setCreationDate(LocalDateTime.now());
        return notesRepository.save(note);
    }


    /**
     * редактирование заметки
     * @param id
     * @param noteDetails
     * @return заметка
     */
    public Note update(Long id, Note noteDetails) {
        Optional<Note> optionalNote = notesRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setHeader(noteDetails.getHeader());
            note.setContent(noteDetails.getContent());
            return notesRepository.save(note);
        } else {
            throw new IllegalArgumentException("Заметка не найдена");
        }
    }

    /**
     * удаление заметки
     * @param id
     */
    public void deleteById(Long id) {
        notesRepository.deleteById(id);
    }
}
