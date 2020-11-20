package pl.com.mazniak.notepad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.mazniak.notepad.model.Note;

import java.sql.Date;
import java.time.LocalDateTime;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

        //tried to implement explicit query
//        @Query(value = "UPDATE notes SET topic = :topic, noteContent = :noteContent, " +
//                "lastModifiedTime = :lastModifiedTime WHERE id = :id")
//        public void updateNote(@Param("id") long id, @Param("topic") String topic, @Param("noteContent") String noteContent,
//                               @Param("lastModifiedTime") Date lastModifiedTime);
}
