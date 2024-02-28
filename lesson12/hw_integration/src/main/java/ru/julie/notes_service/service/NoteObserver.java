package ru.julie.notes_service.service;

import ru.julie.notes_service.model.Note;

public interface NoteObserver {
    void onNoteCreated(Note note);
}