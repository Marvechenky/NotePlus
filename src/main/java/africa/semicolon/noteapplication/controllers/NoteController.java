package africa.semicolon.noteapplication.controllers;

import africa.semicolon.noteapplication.data.dtos.requests.NoteCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.NoteUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.DeleteResponse;
import africa.semicolon.noteapplication.data.dtos.responses.NoteCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.NoteUpdateResponse;
import africa.semicolon.noteapplication.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/note")
public class NoteController {


    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(value = "/create")
    public NoteCreationResponse noteCreationResponse(@RequestBody NoteCreationRequest noteCreationRequest){
        return noteService.createNote(noteCreationRequest);
    }

    @PutMapping(path = "/update")
    public NoteUpdateResponse updateResponse(@RequestBody NoteUpdateRequest noteUpdateRequest){
        return noteService.updateNote(noteUpdateRequest);
    }

    @DeleteMapping(path = "/delete/{name}")
    public DeleteResponse deleteResponse(@PathVariable String name){
        return noteService.deleteNote(name);
    }

    @DeleteMapping(path = "/delete")
    public DeleteResponse deleteResponse(){
        return noteService.deleteAllNotes();
    }
}

