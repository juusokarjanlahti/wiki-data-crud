package fi.haagahelia.wiki_data_crud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DropItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dropItemId;

    private String itemName;
    private int quantity;
    private double dropRate;

    @ManyToOne
    @JoinColumn(name = "dropTableId")
    @JsonIgnore
    private DropTable dropTable;

    // Constructors

    public DropItem() {
    }

    public DropItem(String itemName, int quantity, double dropRate) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.dropRate = dropRate;
    }

    public DropItem(String itemName, int quantity, double dropRate, DropTable dropTable) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.dropRate = dropRate;
        this.dropTable = dropTable;
    }

    public DropItem(Long dropItemId, String itemName, int quantity, double dropRate, DropTable dropTable) {
        this.dropItemId = dropItemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.dropRate = dropRate;
        this.dropTable = dropTable;
    }

    // Getters and setters

    public Long getDropItemId() {
        return dropItemId;
    }

    public void setDropItemId(Long dropItemId) {
        this.dropItemId = dropItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public DropTable getDropTable() {
        return dropTable;
    }

    public void setDropTable(DropTable dropTable) {
        this.dropTable = dropTable;
    }

    // toString

    @Override
    public String toString() {
        return "DropItem [dropItemId=" + dropItemId + ", dropRate=" + dropRate + ", itemName=" + itemName + ", quantity="
                + quantity + "]";
    }
}