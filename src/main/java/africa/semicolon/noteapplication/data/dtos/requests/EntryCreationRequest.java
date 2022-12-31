package africa.semicolon.noteapplication.data.dtos.requests;

import lombok.Data;

@Data
public class EntryCreationRequest {
    private String title;
    private String body;
}
