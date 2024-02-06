package ru.julie.notes_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.julie.notes_service.model.Note;

import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

    Optional<Note> findById(Long id);

}
