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

    public List<DropTable> findAll() {
        return dropTableRepository.findAll();
    }

    public Optional<DropTable> findById(Long id) {
        return dropTableRepository.findById(id);
    }

    public DropTable save(DropTable dropTable) {
        return dropTableRepository.save(dropTable);
    }

    public void deleteById(Long id) {
        dropTableRepository.deleteById(id);
    }
}