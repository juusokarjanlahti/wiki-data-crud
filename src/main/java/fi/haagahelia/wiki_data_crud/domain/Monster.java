package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monsterId;

    @NotBlank(message = "Monster name is required")
    @Size(min = 2, max = 50, message = "Monster name must be between 2 and 50 characters")
    private String monsterName;

    @NotBlank(message = "Monster examine is required")
    @Size(min = 2, max = 255, message = "Monster examine must be between 2 and 255 characters")
    private String monsterExamine;

    @Min(value = 1, message = "Combat level must be at least 1")
    private int combatLevel;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dropTableId", referencedColumnName = "dropTableId")
    private DropTable dropTable;

    // Constructors
    public Monster() {
    }

    public Monster(String monsterName, String monsterExamine, int combatLevel) {
        this.monsterName = monsterName;
        this.monsterExamine = monsterExamine;
        this.combatLevel = combatLevel;
    }

    // Getters and setters
    public Long getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Long monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterExamine() {
        return monsterExamine;
    }

    public void setMonsterExamine(String monsterExamine) {
        this.monsterExamine = monsterExamine;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    public DropTable getDropTable() {
        return dropTable;
    }

    public void setDropTable(DropTable dropTable) {
        this.dropTable = dropTable;
    }
}