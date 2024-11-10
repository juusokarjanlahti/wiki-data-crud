package fi.haagahelia.wiki_data_crud.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.service.DropTableService;

@RestController
@RequestMapping("/dropTables")
public class DropTableController {

    @Autowired
    private DropTableService dropTableService;

    @GetMapping
    public ResponseEntity<List<DropTable>> getAllDropTables() {
        try {
            List<DropTable> dropTables = new ArrayList<>();
            dropTableService.getAllDropTables().forEach(dropTables::add);

            if (dropTables.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dropTables, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DropTable> getDropTableById(@PathVariable("id") Long id) {
        Optional<DropTable> dropTableOptional = Optional.ofNullable(dropTableService.getDropTableById(id));

        if (dropTableOptional.isPresent()) {
            return new ResponseEntity<>(dropTableOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DropTable> createDropTable(@RequestBody DropTable dropTable) {
        try {
            DropTable createdDropTable = dropTableService.createDropTable(dropTable);
            return new ResponseEntity<>(createdDropTable, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DropTable> updateDropTable(@PathVariable("id") Long id, @RequestBody DropTable dropTableDetails) {
        Optional<DropTable> dropTableOptional = Optional.ofNullable(dropTableService.getDropTableById(id));
        if (dropTableOptional.isPresent()) {
            DropTable existingDropTable = dropTableOptional.get();
            existingDropTable.setMonster(dropTableDetails.getMonster());
            existingDropTable.setItems(dropTableDetails.getItems());
            return new ResponseEntity<>(dropTableService.updateDropTable(id, existingDropTable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDropTable(@PathVariable("id") Long id) {
        try {
            boolean isDeleted = dropTableService.deleteDropTable(id);
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