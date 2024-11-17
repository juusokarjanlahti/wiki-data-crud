package fi.haagahelia.wiki_data_crud.dto;

import java.util.List;

public class DropEntryRestDTO {
    private double DropRate;
    private List<String> items;

    // Getters and setters
    public double getDropRate() {
        return DropRate;
    }

    public void setDropRate(double DropRate) {
        this.DropRate = DropRate;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
    
}
