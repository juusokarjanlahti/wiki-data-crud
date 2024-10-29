package fi.haagahelia.wiki_data_crud.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long monster_id;
    private String monster_name;
    private String monster_examine;
    private int combatLevel;

    @OneToOne(mappedBy = "monster", cascade = CascadeType.ALL)
    @JoinColumn(name = "drop_table_id", referencedColumnName = "drop_table_id")
    private DropTable dropTable;
    // Getterit, Setterit, Konstruktorit

    public Monster() {
    }

    public Monster(String monster_name, String monster_examine, int combatLevel) {
        super();
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

    @Override
    public String toString() {
        return "Monster [combatLevel=" + combatLevel + ", monster_examine=" + monster_examine + ", monster_id="
                + monster_id + ", monster_name=" + monster_name + "]";
    }
}