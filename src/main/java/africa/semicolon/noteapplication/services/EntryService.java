package africa.semicolon.noteapplication.services;

import africa.semicolon.noteapplication.data.dtos.requests.EntryCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.EntryUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.EntryCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryDeleteResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryUpdateResponse;

public interface EntryService {

    EntryCreationResponse addEntry(EntryCreationRequest entryCreationRequest);

    EntryUpdateResponse updateEntry(EntryUpdateRequest entryUpdateRequest);

    EntryDeleteResponse deleteEntry(String id);

    EntryDeleteResponse deleteAllEntries();

}
