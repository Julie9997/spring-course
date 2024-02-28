package ru.julie.notes_service.service;

import org.springframework.stereotype.Service;
import ru.julie.notes_service.model.Note;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteSubject {
    private List<NoteObserver> observers = new ArrayList<>();

    public void addObserver(NoteObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NoteObserver observer) {
        observers.remove(observer);
    }

    public void notifyNewNoteCreated(Note note) {
        for (NoteObserver observer : observers) {
            observer.onNoteCreated(note);
        }
    }
}