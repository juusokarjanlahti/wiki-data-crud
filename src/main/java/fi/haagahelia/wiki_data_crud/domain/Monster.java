package fi.haagahelia.wiki_data_crud.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long monsterId;

    private String monsterName;
    private String monsterExamine;
    private int combatLevel;

    @OneToMany(mappedBy = "monster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DropTable> dropTables;

    // Constructors

    public Monster() {
    }

    public Monster(String monsterName, String monsterExamine, int combatLevel) {
        this.monsterName = monsterName;
        this.monsterExamine = monsterExamine;
        this.combatLevel = combatLevel;
    }

    public Monster(String monsterName, String monsterExamine, int combatLevel, List<DropTable> dropTables) {
        this.monsterName = monsterName;
        this.monsterExamine = monsterExamine;
        this.combatLevel = combatLevel;
        this.dropTables = dropTables;
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

    public void addDropTable(DropTable dropTable) {
        this.dropTables.add(dropTable);
        dropTable.setMonster(this);
    }

    public List<DropTable> getDropTables() {
        return dropTables;
    }

    public void setDropTables(List<DropTable> dropTables) {
        this.dropTables = dropTables;
    }

    // toString

    @Override
    public String toString() {
        return "Monster [monsterId=" + monsterId + ", monsterName=" + monsterName + ", monsterExamine=" + monsterExamine
                + ", combatLevel=" + combatLevel + "]";
    }
}