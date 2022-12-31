package africa.semicolon.noteapplication.controllers;

import africa.semicolon.noteapplication.data.dtos.requests.EntryCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.EntryUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.EntryCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryDeleteResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryUpdateResponse;
import africa.semicolon.noteapplication.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/entry")
public class EntryController {

    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService){
        this.entryService = entryService;

    }
    @PostMapping(value = "/addEntry")
    public EntryCreationResponse creationResponse(@RequestBody EntryCreationRequest entryCreationRequest){
        return entryService.addEntry(entryCreationRequest);
    }


    @PutMapping(value = "/update/{id}")
    public EntryUpdateResponse updateResponse(@RequestBody EntryUpdateRequest entryUpdateRequest){
        return entryService.updateEntry(entryUpdateRequest);
    }

    @DeleteMapping(value = "/deleteEntry/{id}")
    public EntryDeleteResponse deleteResponse(@PathVariable String id){
        return entryService.deleteEntry(id);
    }

    @DeleteMapping(value = "/deleteEntries")
    public EntryDeleteResponse deleteResponse(){
        return entryService.deleteAllEntries();
    }

}
