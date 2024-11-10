package fi.haagahelia.wiki_data_crud.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.service.MonsterService;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping
    public ResponseEntity<List<Monster>> getAllMonsters() {
        List<Monster> monsters = monsterService.getAllMonsters();
        return new ResponseEntity<>(monsters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterById(@PathVariable Long id) {
        Monster monster = monsterService.getMonsterById(id);
        if (monster == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Monster> createMonster(@RequestBody Monster monster) {
        Monster createdMonster = monsterService.createMonster(monster);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdMonster.getMonsterId()).toUri();
        return ResponseEntity.created(location).body(createdMonster);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monster> updateMonster(@PathVariable Long id, @RequestBody Monster monsterDetails) {
        Monster existingMonster = monsterService.getMonsterById(id);
        if (existingMonster == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingMonster.setMonsterName(monsterDetails.getMonsterName());
        existingMonster.setMonsterExamine(monsterDetails.getMonsterExamine());
        existingMonster.setCombatLevel(monsterDetails.getCombatLevel());
        existingMonster.setDropTables(monsterDetails.getDropTables());
        Monster updatedMonster = monsterService.updateMonster(id, existingMonster);
        return new ResponseEntity<>(updatedMonster, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMonster(@PathVariable Long id) {
        boolean isDeleted = monsterService.deleteMonster(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}