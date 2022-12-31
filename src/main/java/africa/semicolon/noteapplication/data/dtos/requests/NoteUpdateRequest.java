package africa.semicolon.noteapplication.data.dtos.requests;

import lombok.Data;

@Data
public class NoteUpdateRequest {

    private String id;
    private String name;
}
