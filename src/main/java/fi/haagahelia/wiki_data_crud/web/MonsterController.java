package fi.haagahelia.wiki_data_crud.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.service.MonsterService;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping
    public ResponseEntity<List<Monster>> getAllMonsters() {
        try {
            List<Monster> monsters = new ArrayList<>();
            monsterService.getAllMonsters().forEach(monsters::add);

            if (monsters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(monsters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterById(@PathVariable("id") Long id) {
        Optional<Monster> monsterOptional = Optional.ofNullable(monsterService.getMonsterById(id));

        if (monsterOptional.isPresent()) {
            return new ResponseEntity<>(monsterOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Monster> createMonster(@RequestBody Monster monster) {
        try {
            Monster createdMonster = monsterService.createMonster(monster);
            return new ResponseEntity<>(createdMonster, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monster> updateMonster(@PathVariable("id") Long id, @RequestBody Monster monsterDetails) {
        Optional<Monster> monsterOptional = Optional.ofNullable(monsterService.getMonsterById(id));
        if (monsterOptional.isPresent()) {
            Monster existingMonster = monsterOptional.get();
            existingMonster.setMonsterName(monsterDetails.getMonsterName());
            existingMonster.setMonsterExamine(monsterDetails.getMonsterExamine());
            existingMonster.setCombatLevel(monsterDetails.getCombatLevel());
            existingMonster.setDropTables(monsterDetails.getDropTables());
            return new ResponseEntity<>(monsterService.updateMonster(id, existingMonster), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMonster(@PathVariable("id") Long id) {
        try {
            boolean isDeleted = monsterService.deleteMonster(id);
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