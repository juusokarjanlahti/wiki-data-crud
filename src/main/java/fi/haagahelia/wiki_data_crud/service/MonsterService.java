package fi.haagahelia.wiki_data_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.DropEntry;
import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.repository.MonsterRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    // findAll
    public List<Monster> findAll() {
        return monsterRepository.findAll();
    }

    // findById
    public Monster findById(Long id) {
        return monsterRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Monster not found with id: " + id));
    }

    public Monster save(Monster monster) {
        // Ensure that the DropTable is not unintentionally deleted
        if (monster.getDropTable() != null) {
            List<DropEntry> dropEntries = monster.getDropTable().getDropEntries();
            if (dropEntries == null || dropEntries.isEmpty()) {
                throw new IllegalArgumentException("DropTable must have at least one entry.");
            }
        }
        return monsterRepository.save(monster);
    }

    // deleteById
    public void deleteById(Long id) {
        monsterRepository.deleteById(id);
    }
}