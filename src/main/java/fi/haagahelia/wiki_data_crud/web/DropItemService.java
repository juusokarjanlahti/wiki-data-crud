package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.DropItem;
import fi.haagahelia.wiki_data_crud.domain.DropItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DropItemService {

    @Autowired
    private DropItemRepository dropItemRepository;

    public List<DropItem> getAllDropItems() {
        return (List<DropItem>) dropItemRepository.findAll();
    }

    public Optional<DropItem> getDropItemById(Long id) {
        return dropItemRepository.findById(id);
    }

    public DropItem saveDropItem(DropItem dropItem) {
        return dropItemRepository.save(dropItem);
    }

    public void deleteDropItem(Long id) {
        dropItemRepository.deleteById(id);
    }
}
