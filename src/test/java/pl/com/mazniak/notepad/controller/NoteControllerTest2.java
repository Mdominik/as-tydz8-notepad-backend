package pl.com.mazniak.notepad.controller;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import pl.com.mazniak.notepad.model.Note;
import pl.com.mazniak.notepad.repo.NoteRepo;
import pl.com.mazniak.notepad.service.NoteService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteControllerTest2 {

    @Mock
    private NoteRepo noteRepo;

    @InjectMocks
    private NoteController noteController;


    @Test
    public void getAllNotes() {
        System.out.println();
    }



    @Test
    void findById() {
    }

    @Test
    void addNote() {

    }

    @Test
    void replaceNote() {
    }

    @Test
    void deleteNoteById() {
    }
}