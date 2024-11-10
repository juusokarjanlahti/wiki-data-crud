package fi.haagahelia.wiki_data_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.repository.DropTableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DropTableService {

    @Autowired
    private DropTableRepository dropTableRepository;

    public List<DropTable> getAllDropTables() {
        return dropTableRepository.findAll();
    }

    public DropTable getDropTableById(Long id) {
        Optional<DropTable> dropTable = dropTableRepository.findById(id);
        return dropTable.orElse(null);
    }

    public DropTable createDropTable(DropTable dropTable) {
        return dropTableRepository.save(dropTable);
    }

    public Optional<DropTable> updateDropTable(Long id, DropTable dropTableDetails) {
        return dropTableRepository.findById(id).map(dropTable -> {
            dropTable.setMonster(dropTableDetails.getMonster());
            dropTable.setItems(dropTableDetails.getItems());
            return dropTableRepository.save(dropTable);
        });
    }

    public boolean deleteDropTable(Long id) {
        if (dropTableRepository.existsById(id)) {
            dropTableRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}