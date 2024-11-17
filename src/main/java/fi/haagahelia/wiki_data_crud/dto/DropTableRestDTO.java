package fi.haagahelia.wiki_data_crud.dto;

import java.util.List;

public class DropTableRestDTO {
    private List<DropEntryRestDTO> dropEntries;

    // Getters and setters
    public List<DropEntryRestDTO> getDropEntries() {
        return dropEntries;
    }

    public void setDropEntries(List<DropEntryRestDTO> dropEntries) {
        this.dropEntries = dropEntries;
    }
}
