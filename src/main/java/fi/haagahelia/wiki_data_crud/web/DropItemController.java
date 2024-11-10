package fi.haagahelia.wiki_data_crud.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fi.haagahelia.wiki_data_crud.domain.DropItem;
import fi.haagahelia.wiki_data_crud.service.DropItemService;

@RestController
@RequestMapping("/dropItems")
public class DropItemController {

    @Autowired
    private DropItemService dropItemService;

    @GetMapping
    public ResponseEntity<List<DropItem>> getAllDropItems() {
        List<DropItem> dropItems = dropItemService.getAllDropItems();
        if (dropItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dropItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DropItem> getDropItemById(@PathVariable Long id) {
        Optional<DropItem> dropItemOptional = Optional.ofNullable(dropItemService.getDropItemById(id));
        return dropItemOptional.map(dropItem -> new ResponseEntity<>(dropItem, HttpStatus.OK))
                               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DropItem> createDropItem(@RequestBody DropItem dropItem) {
        try {
            DropItem createdDropItem = dropItemService.createDropItem(dropItem);
            return new ResponseEntity<>(createdDropItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DropItem> updateDropItem(@PathVariable Long id, @RequestBody DropItem dropItemDetails) {
        Optional<DropItem> dropItemOptional = Optional.ofNullable(dropItemService.getDropItemById(id));
        if (dropItemOptional.isPresent()) {
            DropItem existingDropItem = dropItemOptional.get();
            existingDropItem.setItemName(dropItemDetails.getItemName());
            existingDropItem.setQuantity(dropItemDetails.getQuantity());
            existingDropItem.setDropRate(dropItemDetails.getDropRate());
            existingDropItem.setDropTable(dropItemDetails.getDropTable());
            DropItem updatedDropItem = dropItemService.updateDropItem(id, existingDropItem);
            return new ResponseEntity<>(updatedDropItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDropItem(@PathVariable Long id) {
        boolean isDeleted = dropItemService.deleteDropItem(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}