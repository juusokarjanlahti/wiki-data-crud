package fi.haagahelia.wiki_data_crud.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class DropTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dropTableId;

    @ManyToOne
    @JoinColumn(name = "monsterId", referencedColumnName = "monsterId")
    @JsonIgnore
    private Monster monster;

    @OneToMany(mappedBy = "dropTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DropItem> items;

    // Constructors

    public DropTable() {
    }

    public DropTable(Monster monster, List<DropItem> items) {
        this.monster = monster;
        this.items = items;
    }

    public DropTable(Long dropTableId, Monster monster, List<DropItem> items) {
        this.dropTableId = dropTableId;
        this.monster = monster;
        this.items = items;
    }

    public DropTable(Monster monster) {
    this.monster = monster;
    this.items = new ArrayList<>();
    }

    // Getters and setters

    public Long getDropTableId() {
        return dropTableId;
    }

    public void setDropTableId(Long dropTableId) {
        this.dropTableId = dropTableId;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public List<DropItem> getItems() {
        return items;
    }

    public void setItems(List<DropItem> items) {
        this.items = items;
    }

    // toString

    @Override
    public String toString() {
        return "DropTable [dropTableId=" + dropTableId + ", items=" + items + ", monster=" + monster + "]";
    }
}