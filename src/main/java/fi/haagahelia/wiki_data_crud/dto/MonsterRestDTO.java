package fi.haagahelia.wiki_data_crud.dto;

public class MonsterRestDTO {
    private String monsterName;
    private String monsterExamine;
    private int combatLevel;
    private DropTableRestDTO dropTable;

    // Getters and setters
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

    public DropTableRestDTO getDropTable() {
        return dropTable;
    }

    public void setDropTable(DropTableRestDTO dropTable) {
        this.dropTable = dropTable;
    }
}

