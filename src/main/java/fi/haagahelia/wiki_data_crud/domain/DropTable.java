package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class DropTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dropTableId;

    @NotBlank(message = "Drop table name is required")
    @Size(min = 2, max = 50, message = "Drop table name must be between 2 and 50 characters")
    private String dropTableName;

    @OneToOne(mappedBy = "dropTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private Monster monster;

    @OneToMany(mappedBy = "dropTable", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DropEntry> dropEntries;

    // Constructors
    public DropTable() {
    }

    public DropTable(String dropTableName) {
        this.dropTableName = dropTableName;
    }

    // Getters and setters
    public Long getDropTableId() {
        return dropTableId;
    }

    public void setDropTableId(Long dropTableId) {
        this.dropTableId = dropTableId;
    }

    public String getDropTableName() {
        return dropTableName;
    }

    public void setDropTableName(String dropTableName) {
        this.dropTableName = dropTableName;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public List<DropEntry> getDropEntries() {
        return dropEntries;
    }

    public void setDropEntries(List<DropEntry> dropEntries) {
        this.dropEntries = dropEntries;
    }

    public void addDropEntry(DropEntry dropEntry) {
        this.dropEntries.add(dropEntry);
        dropEntry.setDropTable(this);
    }

    @Override
    public String toString() {
        return "DropTable [dropTableId=" + dropTableId + ", dropTableName=" + dropTableName + ", monster=" + monster + "]";
    }
}