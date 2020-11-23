package pl.com.mazniak.notepad.controller;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import pl.com.mazniak.notepad.model.Note;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NoteControllerTest {

    @Test
    void getAllNotes() {
        //given
        NoteController noteController = mock(NoteController.class);
        //when
        when(noteController.getAllNotes()).thenReturn(prepareMockData());
        //then
        Assert.assertThat(noteController.getAllNotes().getBody(), Matchers.hasSize(2));

    }

    private ResponseEntity<List<Note>> prepareMockData() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("To jest moja notatka", "moja notatka"));
        notes.add(new Note("Moja druga notattka", "notatki"));
        return ResponseEntity.ok(notes);
    }

    @Test
    void findById() {
    }

    @Test
    void addNote() {
        NoteController noteController = mock(NoteController.class);
        given(noteController.addNote(Mockito.any(Note.class))).willReturn(ResponseEntity.ok(new Note("sad", "asd")));
        ResponseEntity<Note> note = noteController.addNote(new Note());

        Assert.assertEquals(note.getBody().getTopic(), "asd");
    }

    @Test
    void replaceNote() {
    }

    @Test
    void deleteNoteById() {
    }
}