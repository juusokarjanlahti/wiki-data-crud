package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DropTable { // rename DropTable to DropItem
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long drop_table_id;
    private String itemName;
    private int quantity;
    private double dropRate;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Monster monster;

    public DropTable() {
    }

    public DropTable(String itemName, int quantity, double dropRate) {
        super();
        this.itemName = itemName;
        this.quantity = quantity;
        this.dropRate = dropRate;
    }

    // id
    public Long getDrop_table_id() {
        return drop_table_id;
    }

    public void setDrop_table_id(Long drop_table_id) {
        this.drop_table_id = drop_table_id;
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
        return "DropTable [drop_table_id=" + drop_table_id + ", itemName=" + itemName + ", quantity=" + quantity + ", dropRate=" + dropRate + "]";
    }
}