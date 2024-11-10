package fi.haagahelia.wiki_data_crud.web;

import java.util.ArrayList;
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
        try {
            List<DropItem> dropItems = new ArrayList<>();
            dropItemService.getAllDropItems().forEach(dropItems::add);

            if (dropItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dropItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DropItem> getDropItemById(@PathVariable("id") Long id) {
        Optional<DropItem> dropItemOptional = Optional.ofNullable(dropItemService.getDropItemById(id));

        if (dropItemOptional.isPresent()) {
            return new ResponseEntity<>(dropItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<DropItem> updateDropItem(@PathVariable("id") Long id, @RequestBody DropItem dropItemDetails) {
        Optional<DropItem> dropItemOptional = Optional.ofNullable(dropItemService.getDropItemById(id));
        if (dropItemOptional.isPresent()) {
            DropItem existingDropItem = dropItemOptional.get();
            existingDropItem.setItemName(dropItemDetails.getItemName());
            existingDropItem.setQuantity(dropItemDetails.getQuantity());
            existingDropItem.setDropRate(dropItemDetails.getDropRate());
            existingDropItem.setDropTable(dropItemDetails.getDropTable());
            return new ResponseEntity<>(dropItemService.updateDropItem(id, existingDropItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDropItem(@PathVariable("id") Long id) {
        try {
            boolean isDeleted = dropItemService.deleteDropItem(id);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}