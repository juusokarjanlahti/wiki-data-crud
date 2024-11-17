package fi.haagahelia.wiki_data_crud.service;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.repository.DropTableRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropTableService {

    @Autowired
    private DropTableRepository dropTableRepository;

    public List<DropTable> findAll() {
        return dropTableRepository.findAll();
    }

    public DropTable findById(Long id) {
        return dropTableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DropTable not found with id: " + id));
    }

    public DropTable save(DropTable dropTable) {
        if (dropTable.getDropEntries().isEmpty()) {
            throw new IllegalArgumentException("DropTable must have at least one entry.");
        }
        return dropTableRepository.save(dropTable);
    }

    public void deleteById(Long id) {
        dropTableRepository.deleteById(id);
    }
}