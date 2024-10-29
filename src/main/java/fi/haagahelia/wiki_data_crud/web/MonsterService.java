package fi.haagahelia.wiki_data_crud.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.DropTableRepository;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.DropTable;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private DropTableRepository dropTableRepository;

    public Optional<Monster> getMonster(Long monster_id) {
        return monsterRepository.findById(monster_id);
    }

    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    public Optional<DropTable> getDropTable(Long drop_table_id) {
        return dropTableRepository.findById(drop_table_id);
    }

    public Optional<Monster> getMonsterWithDropTables(Long monster_id) {
        Optional<Monster> monster = monsterRepository.findById(monster_id);
        if (monster.isPresent()) {
            // Fetch drop tables and items eagerly if not already fetched
            monster.get().getDropTable().size(); // Trigger lazy loading
            for (DropTable dropTable : monster.get().getDropTable()) {
                dropTable.getItems().size(); // Trigger lazy loading
            }
        }
        return monster;
    }

}
