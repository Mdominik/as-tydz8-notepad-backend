package pl.com.mazniak.notepad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.com.mazniak.notepad.controller.NoteController;
import pl.com.mazniak.notepad.model.Note;
import pl.com.mazniak.notepad.repo.NoteRepo;

@Service
public class NoteService {

    NoteController noteController;

    public NoteService(NoteController noteController) {
        this.noteController = noteController;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        noteController.addNote(new Note("Dzisiaj jest piatek", "Dzien"));

    }

}
