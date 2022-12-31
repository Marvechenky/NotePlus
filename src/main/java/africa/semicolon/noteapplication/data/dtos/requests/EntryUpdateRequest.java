package africa.semicolon.noteapplication.data.dtos.requests;

import lombok.Data;

@Data
public class EntryUpdateRequest {
    private String id;
    private String title;
    private String body;
}
