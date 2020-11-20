package pl.com.mazniak.notepad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.com.mazniak.notepad.model.Note;
import pl.com.mazniak.notepad.repo.NoteRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NoteController {
    NoteRepo noteRepo;

    public NoteController(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    @GetMapping("all")
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteRepo.findAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Note> findById(@PathVariable long id) {
        Optional<Note> note = noteRepo.findById(id);
        System.out.println(note.get().getLastModifiedTime());
        return note.isPresent() ? ResponseEntity.ok(note.get()) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity addNote(@RequestBody Note newNote) {
        Note note = noteRepo.save(newNote);
        System.out.println(note.getLastModifiedTime());
        return note != null ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity replaceNote(@RequestBody Note note) {
        Optional<Note> noteDB = noteRepo.findById(note.getId());
        if(noteDB.isPresent()) {
            LocalDateTime saveCreationTime = noteDB.get().getCreatedTime();
            noteRepo.deleteById(noteDB.get().getId());
            note.setCreatedTime(saveCreationTime);
            note.setLastModifiedTime(LocalDateTime.now());
            System.out.println(note.getLastModifiedTime());
            noteRepo.save(note);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNoteById(@PathVariable long id) {
        if (noteRepo.findById(id).isPresent()) {
            noteRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
