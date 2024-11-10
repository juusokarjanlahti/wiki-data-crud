package fi.haagahelia.wiki_data_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.repository.MonsterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    public Monster getMonsterById(Long id) {
        Optional<Monster> monster = monsterRepository.findById(id);
        return monster.orElse(null);
    }

    public Monster createMonster(Monster monster) {
        return monsterRepository.save(monster);
    }

    public Monster updateMonster(Long id, Monster monsterDetails) {
        return monsterRepository.findById(id).map(monster -> {
            monster.setMonsterName(monsterDetails.getMonsterName());
            monster.setMonsterExamine(monsterDetails.getMonsterExamine());
            monster.setCombatLevel(monsterDetails.getCombatLevel());
            monster.setDropTables(monsterDetails.getDropTables());
            return monsterRepository.save(monster);
        }).orElse(null);
    }

    public boolean deleteMonster(Long id) {
        if (monsterRepository.existsById(id)) {
            monsterRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}