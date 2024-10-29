package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long monster_id;
    private String monster_name;
    private String monster_examine;
    private int combatLevel;

    @OneToMany(mappedBy = "monster", cascade = CascadeType.ALL)
    private List<DropTable> dropTable;

    public Monster() {
    }

    public Monster(String monster_name, String monster_examine, int combatLevel) {
        this.monster_name = monster_name;
        this.monster_examine = monster_examine;
        this.combatLevel = combatLevel;
    }

    public Long getMonster_id() {
        return monster_id;
    }

    public void setMonster_id(Long monster_id) {
        this.monster_id = monster_id;
    }

    public String getMonster_name() {
        return monster_name;
    }

    public void setMonster_name(String monster_name) {
        this.monster_name = monster_name;
    }

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