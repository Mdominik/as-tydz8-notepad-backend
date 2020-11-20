package pl.com.mazniak.notepad.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String noteContent;
    private String topic;
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;

    public Note(String noteContent, String topic) {
        this.noteContent = noteContent;
        this.topic = topic;
        this.createdTime = LocalDateTime.now();
        this.lastModifiedTime = LocalDateTime.now();
    }

    public Note() {
    }

    public void updateNote(Note note) {
        setNoteContent(note.getNoteContent());
        setTopic(note.getTopic());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
        this.createdTime = LocalDateTime.now();
        this.lastModifiedTime = LocalDateTime.now();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
        this.createdTime = LocalDateTime.now();
        this.lastModifiedTime = LocalDateTime.now();
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}