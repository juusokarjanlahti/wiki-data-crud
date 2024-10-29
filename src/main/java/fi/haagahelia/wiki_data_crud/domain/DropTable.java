package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class DropTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drop_table_id;

    private String itemName;
    private int quantity;
    private double dropRate;

    @ManyToOne
    @JoinColumn(name = "monster_id", referencedColumnName = "monster_id")
    private Monster monster;

    @OneToMany(mappedBy = "dropTable", cascade = CascadeType.ALL)
    private List<Item> items;

    // Getters, Setters, Constructors

    public DropTable() {
    }

    public DropTable(String itemName, int quantity, double dropRate, Monster monster) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.dropRate = dropRate;
        this.monster = monster;
    }

    public Long getDrop_table_id() {
        return drop_table_id;
    }

    public void setDrop_table_id(Long drop_table_id) {
        this.drop_table_id = drop_table_id;
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

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "DropTable [drop_table_id=" + drop_table_id + ", itemName=" + itemName + ", quantity=" + quantity + ", dropRate=" + dropRate + "]";
    }
}