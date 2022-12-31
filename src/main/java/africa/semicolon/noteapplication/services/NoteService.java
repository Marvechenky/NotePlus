package africa.semicolon.noteapplication.services;

import africa.semicolon.noteapplication.data.dtos.requests.NoteCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.NoteUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.NoteCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.NoteUpdateResponse;
import africa.semicolon.noteapplication.data.dtos.responses.DeleteResponse;

public interface NoteService {

    NoteCreationResponse createNote(NoteCreationRequest noteCreationRequest);

    NoteUpdateResponse updateNote(NoteUpdateRequest noteUpdateRequest);

    DeleteResponse deleteNote(String name);

    DeleteResponse deleteAllNotes();
}
