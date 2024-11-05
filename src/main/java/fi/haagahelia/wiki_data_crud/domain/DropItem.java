package fi.haagahelia.wiki_data_crud.domain;

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
    private Long dropId;
    private String itemName;
    private int quantity;
    private double dropRate;

    @ManyToOne
    @JoinColumn(name = "monsterId", referencedColumnName = "monsterId")
    private Monster monster;

    public DropItem() {}

    public DropItem(String itemName, int quantity, double dropRate, Monster monster) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.dropRate = dropRate;
        this.monster = monster;
    }

    // monsterId
    public Long getDropId() {
        return dropId;
    }

    public void setDropId(Long dropId) {
        this.dropId = dropId;
    }

    // name
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // drop rate
    public double getDropRate() {
        return dropRate;
    }

    public void setDropRate(double dropRate) {
        this.dropRate = dropRate;
    }

    // monster
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String toString() {
        return "DropItem [dropId=" + dropId + ", itemName=" + itemName + 
               ", quantity=" + quantity + ", dropRate=" + dropRate + "]";
    }
}