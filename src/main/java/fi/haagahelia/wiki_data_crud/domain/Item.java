package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private int itemValue;
    private boolean itemIsStackable;
    
    // Constructors
    public Item() {
    }

    public Item(String itemName, int itemValue, boolean itemIsStackable) {
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.itemIsStackable = itemIsStackable;
    }

    // Getters and setters

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public boolean isItemIsStackable() {
        return itemIsStackable;
    }

    public void setItemIsStackable(boolean itemIsStackable) {
        this.itemIsStackable = itemIsStackable;
    }

    @Override
    public String toString() {
        return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemValue=" + itemValue + ", itemIsStackable="
                + itemIsStackable + "]";
    }
}