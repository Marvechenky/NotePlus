package africa.semicolon.noteapplication.services;
import africa.semicolon.noteapplication.data.dtos.requests.EntryCreationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.EntryUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.EntryCreationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryDeleteResponse;
import africa.semicolon.noteapplication.data.dtos.responses.EntryUpdateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EntryServiceImplTest {

    @Autowired
    private EntryService entryService;

    private EntryCreationRequest entryCreationRequest;
    private EntryUpdateRequest entryUpdateRequest;


    @BeforeEach
    void setUp() {
        entryCreationRequest = new EntryCreationRequest();
        entryCreationRequest.setTitle("How to spend the money you do not have");
        entryCreationRequest.setBody("You thief! Go and hustle. Ko le werk, you fucking criminal!....");

    }


    @Test
    void authenticatedUserCanAddEntryToNote_Test(){
        EntryCreationResponse entryCreationResponse
                = entryService.addEntry(entryCreationRequest);
        System.out.println(entryCreationResponse);
        assertNotNull(entryCreationResponse);
       assertEquals("Entry added successfully",  entryCreationResponse.getMessage());
    }

    @Test
    void addedEntryCanBeUpdatedByAuthenticatedUser_Test(){
        entryUpdateRequest = new EntryUpdateRequest();
        entryUpdateRequest.setId("63aebb08c838ad31b2c2f92c");
        entryUpdateRequest.setTitle("How to make the money that you did not spend");
        entryUpdateRequest.setBody("Shebi you know you're a thief, bah?........");
        EntryUpdateResponse entryUpdateResponse
                = entryService.updateEntry(entryUpdateRequest);
        System.out.println(entryUpdateResponse);
        assertNotNull(entryUpdateResponse);
        assertEquals("entry updated successfully", entryUpdateResponse.getMessage());
    }


    @Test
    void EntryCanBeDeleted_Test(){
        EntryDeleteResponse entryDeleteResponse
                = entryService.deleteEntry("63a7264567f3871389f4a33f");
        assertEquals("entry deleted successfully", entryDeleteResponse.getMessage());

    }

    @Test
    void AllEntriesCanBeDeleted_Test(){
        EntryDeleteResponse entryDeleteResponse
                = entryService.deleteAllEntries();
        assertEquals("all entries deleted successfully", entryDeleteResponse.getMessage());
    }
}