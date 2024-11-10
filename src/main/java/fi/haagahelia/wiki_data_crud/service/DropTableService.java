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

    public DropTable updateDropTable(Long id, DropTable dropTableDetails) {
        Optional<DropTable> optionalDropTable = dropTableRepository.findById(id);
        if (optionalDropTable.isPresent()) {
            DropTable dropTable = optionalDropTable.get();
            dropTable.setMonster(dropTableDetails.getMonster());
            dropTable.setItems(dropTableDetails.getItems());
            return dropTableRepository.save(dropTable);
        } else {
            return null;
        }
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