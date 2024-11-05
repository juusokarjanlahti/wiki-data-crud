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

    @OneToMany(mappedBy = "monster", cascade = CascadeType.ALL)
    private List<DropItem> dropItem;

    public Monster() {
    }

    public Monster(String monsterName, String monsterExamine, int combatLevel) {
        super();
        this.monsterName = monsterName;
        this.monsterExamine = monsterExamine;
        this.combatLevel = combatLevel;
    }

    // monsterId
    public Long getId() {
        return monsterId;
    }

    public void setId(Long monsterId) {
        this.monsterId = monsterId;
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

    // drop item
    public List<DropItem> getDropItem() {
        return dropItem;
    }


    public void setDropItem(List<DropItem> dropItem) {
        this.dropItem = dropItem;
        for (DropItem item : dropItem) {
            item.setMonster(this); // Set the reverse relationship
        }
    }

    @Override
    public String toString() {
        return "Monster [monsterId=" + monsterId + ", monsterName=" + monsterName + ", monsterExamine=" + monsterExamine + ", combatLevel=" + combatLevel + "]";
    }
}