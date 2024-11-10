package fi.haagahelia.wiki_data_crud.web;

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
        List<DropTable> dropTables = dropTableService.getAllDropTables();
        if (dropTables.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dropTables, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DropTable> getDropTableById(@PathVariable Long id) {
        Optional<DropTable> dropTableOptional = Optional.ofNullable(dropTableService.getDropTableById(id));
        return dropTableOptional.map(dropTable -> new ResponseEntity<>(dropTable, HttpStatus.OK))
                                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
    public ResponseEntity<DropTable> updateDropTable(@PathVariable Long id, @RequestBody DropTable dropTableDetails) {
        Optional<DropTable> dropTableOptional = Optional.ofNullable(dropTableService.getDropTableById(id));
        if (dropTableOptional.isPresent()) {
            DropTable existingDropTable = dropTableOptional.get();
            existingDropTable.setMonster(dropTableDetails.getMonster());
            existingDropTable.setItems(dropTableDetails.getItems());
            DropTable updatedDropTable = dropTableService.updateDropTable(id, existingDropTable);
            return new ResponseEntity<>(updatedDropTable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDropTable(@PathVariable Long id) {
        boolean isDeleted = dropTableService.deleteDropTable(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}