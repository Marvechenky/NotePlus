package africa.semicolon.noteapplication.services;

import africa.semicolon.noteapplication.data.dtos.requests.NoteCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.NoteUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.NoteCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.NoteUpdateResponse;
import africa.semicolon.noteapplication.data.dtos.responses.DeleteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoteServiceImplTest {

    @Autowired
    private NoteService noteService;
    private NoteCreationRequest noteCreationRequest;


    @BeforeEach
    void setUp() {
        noteCreationRequest = new NoteCreationRequest();
        noteCreationRequest.setName("Design Pattern");

    }

    @Test
    void NoteCanBeCreated_Test(){
        NoteCreationResponse noteCreationResponse
                = noteService.createNote(noteCreationRequest);
        assertNotNull(noteCreationResponse);
        System.out.println(noteCreationResponse);
        assertEquals("note created successfully", noteCreationResponse.getMessage());
    }


    @Test
    void createdNoteDetailCanBeUpdated_Test(){
        NoteUpdateRequest noteUpdateRequest
                = new NoteUpdateRequest();
        noteUpdateRequest.setId("63afdf8d93e1f8189b9ad718");
        noteUpdateRequest.setName("Dependency Injection");
        NoteUpdateResponse noteUpdateResponse
                = noteService.updateNote(noteUpdateRequest);
        assertNotNull(noteUpdateResponse);
        System.out.println(noteUpdateResponse);
        assertEquals("note detail updated successfully", noteUpdateResponse.getMessage());

    }

    @Test
    void createdNoteCanBeDeleted_Test(){
        DeleteResponse deleteResponse
                = noteService.deleteNote("Dependency Injection");
        assertEquals("note deleted", deleteResponse.getMessage());
    }

    @Test
    void allCreatedNotesCanBeDeleted_Test(){
        DeleteResponse deleteResponse
                = noteService.deleteAllNotes();
        assertEquals("all notes deleted", deleteResponse.getMessage());
    }
}