package fi.haagahelia.wiki_data_crud.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @NotBlank(message = "Item name is required")
    @Size(min = 2, max = 50, message = "Item name must be between 2 and 50 characters")
    private String itemName;

    @Min(value = 0, message = "Item value must be at least 0")
    private int itemValue;

    private boolean itemIsStackable;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DropEntry> dropEntries;
    
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