package ru.julie.noteservicetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.julie.noteservicetest.model.Note;
import ru.julie.noteservicetest.repository.NotesRepository;
import ru.julie.noteservicetest.service.NotesService;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {
    @Mock
    private NotesRepository notesRepository;

    @InjectMocks
    private NotesService notesService;

    @Test
    public void findNoteByIdTest() {
        Note note = new Note("header", "content");
        given(notesRepository.findById(1L)).willReturn(Optional.of(note));

        notesService.findById(1L);
        verify(notesRepository).findById(1L);

        Assertions.assertEquals(note, notesRepository.findById(1L).get());
    }
}
