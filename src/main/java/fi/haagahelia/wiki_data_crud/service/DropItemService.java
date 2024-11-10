package fi.haagahelia.wiki_data_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.wiki_data_crud.domain.DropItem;
import fi.haagahelia.wiki_data_crud.repository.DropItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DropItemService {

    @Autowired
    private DropItemRepository dropItemRepository;

    public List<DropItem> getAllDropItems() {
        return dropItemRepository.findAll();
    }

    public Optional<DropItem> getDropItemById(Long id) {
        return dropItemRepository.findById(id);
    }

    public DropItem createDropItem(DropItem dropItem) {
        return dropItemRepository.save(dropItem);
    }

    public Optional<DropItem> updateDropItem(Long id, DropItem dropItemDetails) {
        return dropItemRepository.findById(id).map(dropItem -> {
            dropItem.setItemName(dropItemDetails.getItemName());
            dropItem.setQuantity(dropItemDetails.getQuantity());
            dropItem.setDropRate(dropItemDetails.getDropRate());
            dropItem.setDropTable(dropItemDetails.getDropTable());
            return dropItemRepository.save(dropItem);
        });
    }

    public boolean deleteDropItem(Long id) {
        if (dropItemRepository.existsById(id)) {
            dropItemRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}