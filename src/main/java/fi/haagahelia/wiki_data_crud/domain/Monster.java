package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monsterId;
    private String monsterName;
    private String monsterExamine;
    private int combatLevel;

    @OneToOne
    @JoinColumn(name = "dropTableId")
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