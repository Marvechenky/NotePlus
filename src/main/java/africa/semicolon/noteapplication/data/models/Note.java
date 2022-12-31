package africa.semicolon.noteapplication.data.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Note")
public class Note {

    private String name;

    @Id
    private String id;

    @DBRef
    private List<Entry> entries = new ArrayList<>();

}
