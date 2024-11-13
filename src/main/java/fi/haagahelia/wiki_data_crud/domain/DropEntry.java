package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DropEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dropEntryId;
    
    @ManyToOne
    @JoinColumn(name = "dropTableId")
    private DropTable dropTable;
    
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;
    
    private int quantity;
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
