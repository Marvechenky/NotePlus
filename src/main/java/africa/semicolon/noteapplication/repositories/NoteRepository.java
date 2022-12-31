package africa.semicolon.noteapplication.repositories;

import africa.semicolon.noteapplication.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

    void deleteByName(String name);

    Optional<Note> findByName(String name);
}
