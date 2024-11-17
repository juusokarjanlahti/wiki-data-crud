package fi.haagahelia.wiki_data_crud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class DropEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dropEntryId;

    @ManyToOne
    @JoinColumn(name = "dropTableId")
    @JsonIgnore
    private DropTable dropTable;

    @ManyToOne
    @JoinColumn(name = "itemId")
    @NotNull(message = "Item is required")
    private Item item;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @Min(value = 0, message = "Drop rate must be at least 0")
    private double dropRate;

    // Constructors

    public DropEntry() {
    }

    public DropEntry(DropTable dropTable, Item item, int quantity, double dropRate) {
        this.dropTable = dropTable;
        this.item = item;
        this.quantity = quantity;
        this.dropRate = dropRate;
    }

    // Getters and setters
    public Long getDropEntryId() {
        return dropEntryId;
    }

    public void setDropEntryId(Long dropEntryId) {
        this.dropEntryId = dropEntryId;
    }

    public DropTable getDropTable() {
        return dropTable;
    }

    public void setDropTable(DropTable dropTable) {
        this.dropTable = dropTable;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDropRate() {
        return dropRate;
    }

    public void setDropRate(double dropRate) {
        this.dropRate = dropRate;
    }

    @Override
    public String toString() {
        return "DropEntry [dropEntryId=" + dropEntryId + ", dropTable=" + dropTable + ", item=" + item + ", quantity="
                + quantity + ", dropRate=" + dropRate + "]";
    }
}
