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
    private Long id;
    private String monsterName;
    private String monsterExamine;
    private int combatLevel;

    @OneToMany(mappedBy = "monster", cascade = CascadeType.ALL)
    private List<DropTable> dropTable;

    public Monster() {
    }

    public Monster(String monsterName, String monsterExamine, int combatLevel) {
        super();
        this.monsterName = monsterName;
        this.monsterExamine = monsterExamine;
        this.combatLevel = combatLevel;
    }

    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // name
    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    // examine
    public String getMonsterExamine() {
        return monsterExamine;
    }

    public void setMonsterExamine(String monsterExamine) {
        this.monsterExamine = monsterExamine;
    }

    // combat level
    public int getCombatLevel() {
        return combatLevel;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    // drop table
    public List<DropTable> getDropTable() {
        return dropTable;
    }

    public void setDropTable(List<DropTable> dropTable) {
        this.dropTable = dropTable;
    }

    @Override
    public String toString() {
        return "Monster [id=" + id + ", monsterName=" + monsterName + ", monsterExamine=" + monsterExamine + ", combatLevel=" + combatLevel + "]";
    }
}