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
    private Long monster_id;
    private String monster_name;
    private String monster_examine;
    private int combatLevel;

    @OneToMany(mappedBy = "monster", cascade = CascadeType.ALL)
    private List<DropTable> dropTable;

    public Monster() {
    }

    public Monster(String monster_name, String monster_examine, int combatLevel) {
        super();
        this.monster_name = monster_name;
        this.monster_examine = monster_examine;
        this.combatLevel = combatLevel;
    }

    // id
    public Long getMonster_id() {
        return monster_id;
    }

    public void setMonster_id(Long monster_id) {
        this.monster_id = monster_id;
    }

    // name
    public String getMonster_name() {
        return monster_name;
    }

    public void setMonster_name(String monster_name) {
        this.monster_name = monster_name;
    }

    // examine
    public String getMonster_examine() {
        return monster_examine;
    }

    public void setMonster_examine(String monster_examine) {
        this.monster_examine = monster_examine;
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
        return "Monster [combatLevel=" + combatLevel + ", monster_examine=" + monster_examine + ", monster_id="
                + monster_id + ", monster_name=" + monster_name + "]";
    }
}