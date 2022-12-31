package africa.semicolon.noteapplication.services;

import africa.semicolon.noteapplication.data.dtos.requests.EntryCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.EntryUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.EntryCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryDeleteResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryUpdateResponse;
import africa.semicolon.noteapplication.data.models.Entry;
import africa.semicolon.noteapplication.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl implements EntryService{

    private final EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Override
    public EntryCreationResponse addEntry(EntryCreationRequest entryCreationRequest) {
        Entry entry = new Entry();
        entry.setTitle(entryCreationRequest.getTitle());
        entry.setBody(entryCreationRequest.getBody());
        Entry savedEntry = entryRepository.save(entry);
        EntryCreationResponse entryCreationResponse
                = new EntryCreationResponse();
        entryCreationResponse.setId(savedEntry.getId());
        entryCreationResponse.setStatusCode(201);
        entryCreationResponse.setMessage("Entry added successfully");
        return entryCreationResponse;
    }

    @Override
    public EntryUpdateResponse updateEntry(EntryUpdateRequest entryUpdateRequest) {
        Entry foundEntry = entryRepository.findById(entryUpdateRequest.getId())
                .orElseThrow(()-> new RuntimeException("Oops!...Entry not found"));
        foundEntry.setId(entryUpdateRequest.getId());
        foundEntry.setTitle(entryUpdateRequest.getTitle());
        foundEntry.setBody(entryUpdateRequest.getBody());
        entryRepository.save(foundEntry);
        EntryUpdateResponse entryUpdateResponse = new EntryUpdateResponse();
        entryUpdateResponse.setMessage("entry updated successfully");
        return entryUpdateResponse;
    }

    @Override
    public EntryDeleteResponse deleteEntry(String id) {
        EntryDeleteResponse entryDeleteResponse = new EntryDeleteResponse();
        entryRepository.deleteById(id);
        entryDeleteResponse.setMessage("entry deleted successfully");
        return entryDeleteResponse;
    }

    @Override
    public EntryDeleteResponse deleteAllEntries() {
        EntryDeleteResponse entryDeleteResponse = new EntryDeleteResponse();
        entryDeleteResponse.setMessage("all entries deleted successfully");
        entryRepository.deleteAll();
        return entryDeleteResponse;
    }


}
