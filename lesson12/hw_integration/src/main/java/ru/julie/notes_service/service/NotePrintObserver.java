package ru.julie.notes_service.service;

import ru.julie.notes_service.model.Note;

public class NotePrintObserver implements NoteObserver {

    @Override
    public void onNoteCreated(Note note) {
        System.out.println("New Note Created:");
        System.out.println("Header: " + note.getHeader());
        System.out.println("Content: " + note.getContent());
        System.out.println();
    }
}