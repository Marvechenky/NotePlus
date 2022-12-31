package africa.semicolon.noteapplication.services;

import africa.semicolon.noteapplication.data.dtos.requests.NoteCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.NoteUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.NoteCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.NoteUpdateResponse;
import africa.semicolon.noteapplication.data.dtos.responses.DeleteResponse;
import africa.semicolon.noteapplication.data.models.Note;
import africa.semicolon.noteapplication.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteCreationResponse createNote(NoteCreationRequest noteCreationRequest) {
        Note note = new Note();
        note.setName(noteCreationRequest.getName());
        noteRepository.save(note);

        NoteCreationResponse noteCreationResponse
                = new NoteCreationResponse();
        noteCreationResponse.setMessage("note created successfully");
        return noteCreationResponse;

    }

    @Override
    public NoteUpdateResponse updateNote(NoteUpdateRequest noteUpdateRequest) {
        Note foundNote = noteRepository.findByName(noteUpdateRequest.getName())
                .orElseThrow(()-> new RuntimeException("note does not exist"));
        foundNote.setId(noteUpdateRequest.getId());
        foundNote.setName(noteUpdateRequest.getName());
        noteRepository.save(foundNote);

        NoteUpdateResponse noteUpdateResponse
                = new NoteUpdateResponse();
        noteUpdateResponse.setMessage("note detail updated successfully");
        return noteUpdateResponse;
    }

    @Override
    public DeleteResponse deleteNote(String name) {
        noteRepository.deleteByName(name);
        return new DeleteResponse("note deleted");
    }

    @Override
    public DeleteResponse deleteAllNotes() {
        noteRepository.deleteAll();
        return new DeleteResponse("all notes deleted");
    }
}
