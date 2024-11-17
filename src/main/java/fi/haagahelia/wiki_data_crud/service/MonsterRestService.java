package fi.haagahelia.wiki_data_crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.dto.DropEntryRestDTO;
import fi.haagahelia.wiki_data_crud.dto.DropTableRestDTO;
import fi.haagahelia.wiki_data_crud.dto.MonsterRestDTO;
import fi.haagahelia.wiki_data_crud.repository.MonsterRepository;

@Service
public class MonsterRestService {
    private final MonsterRepository monsterRepository;

    public MonsterRestService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public List<MonsterRestDTO> getAllMonsters() {
        List<Monster> monsters = monsterRepository.findAll();
        return monsters.stream()
                .map(this::convertToRestDTO)
                .collect(Collectors.toList());
    }

    private MonsterRestDTO convertToRestDTO(Monster monster) {
        MonsterRestDTO dto = new MonsterRestDTO();
        dto.setMonsterName(monster.getMonsterName());
        dto.setMonsterExamine(monster.getMonsterExamine());
        dto.setCombatLevel(monster.getCombatLevel());

        if (monster.getDropTable() != null) {
            DropTableRestDTO dropTableDTO = new DropTableRestDTO();
            dropTableDTO.setDropEntries(
                monster.getDropTable().getDropEntries().stream().map(entry -> {
                    DropEntryRestDTO entryDTO = new DropEntryRestDTO();
                    entryDTO.setDropRate(entry.getDropRate());
                    entryDTO.setItems(List.of(entry.getItem().getItemName()));
                    return entryDTO;
                }).collect(Collectors.toList())
            );
            dto.setDropTable(dropTableDTO);
        }

        return dto;
    }
}