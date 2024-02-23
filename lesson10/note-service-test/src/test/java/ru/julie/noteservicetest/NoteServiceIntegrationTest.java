package ru.julie.noteservicetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.julie.noteservicetest.model.Note;
import ru.julie.noteservicetest.repository.NotesRepository;
import ru.julie.noteservicetest.service.NotesService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class NoteServiceIntegrationTest {
    @MockBean
    private NotesRepository notesRepository;

    @Autowired
    private NotesService noteService;

    @Test
    public void updateNoteGoodTest(){
        // Arrange
        Note note = new Note("header", "content");
        Note updateNote = new Note("newHeader", "newContent");

        // act
        given(notesRepository.findById(note.getId())).willReturn(Optional.of(updateNote));
        noteService.update(note.getId(), updateNote);

        // assertions
        Assertions.assertEquals(updateNote ,notesRepository.findById(note.getId()).get());
    }
}
