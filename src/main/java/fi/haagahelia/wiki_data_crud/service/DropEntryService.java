package fi.haagahelia.wiki_data_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.DropEntry;
import fi.haagahelia.wiki_data_crud.domain.DropEntryRepository;

@Service
public class DropEntryService {
    
    @Autowired
    private DropEntryRepository dropEntryRepository;

    public List<DropEntry> findAll() {
        return dropEntryRepository.findAll();
    }

    public Optional<DropEntry> findById(Long id) {
        return dropEntryRepository.findById(id);
    }

    public DropEntry save(DropEntry dropEntry) {
        return dropEntryRepository.save(dropEntry);
    }

    public void deleteById(Long id) {
        dropEntryRepository.deleteById(id);
    }
}
