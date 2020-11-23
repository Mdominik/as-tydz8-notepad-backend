package pl.com.mazniak.notepad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.mazniak.notepad.model.Note;

import java.time.LocalDateTime;
import java.util.Date;


@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

        //tried to implement explicit query
        @Query(value = "UPDATE notes SET topic = :topic, lastModifiedTime = :lastModifiedTime WHERE id = :id",
                 nativeQuery = true)
        public void updateOnlyTopic(@Param("id") long id, @Param("topic") String topic,
                                    @Param("lastModifiedTime") LocalDateTime lastModifiedTime);

        //tried to implement explicit query
        @Query(value = "UPDATE notes SET noteContent = :noteContent, lastModifiedTime = :lastModifiedTime, topic = :topic WHERE id = :id"
                , nativeQuery = true)
        public void updateTopicAndContent(@Param("id") long id, @Param("topic") String topic, @Param("noteContent") String noteContent,
                                        @Param("lastModifiedTime") LocalDateTime lastModifiedTime);


        //tried to implement explicit query
        @Query(value = "UPDATE notes SET noteContent = :noteContent, lastModifiedTime = :lastModifiedTime  WHERE id = :id"
                , nativeQuery = true)
        public void updateOnlyContent(@Param("id") long id, @Param("noteContent") String noteContent,
                                          @Param("lastModifiedTime") LocalDateTime lastModifiedTime);
}
