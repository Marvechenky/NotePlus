package africa.semicolon.noteapplication.data.dtos.responses;

import lombok.Data;

@Data
public class EntryCreationResponse {
    private String id;
    private int statusCode;
    private String message;
}
