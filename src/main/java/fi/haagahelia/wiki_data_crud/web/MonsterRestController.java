package fi.haagahelia.wiki_data_crud.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.wiki_data_crud.dto.MonsterRestDTO;
import fi.haagahelia.wiki_data_crud.service.MonsterRestService;

@RestController
@RequestMapping("/api")
public class MonsterRestController {
    private final MonsterRestService monsterRestService;

    public MonsterRestController(MonsterRestService monsterRestService) {
        this.monsterRestService = monsterRestService;
    }

    @GetMapping
    public ResponseEntity<List<MonsterRestDTO>> getAllMonsters() {
        List<MonsterRestDTO> monsters = monsterRestService.getAllMonsters();
        return ResponseEntity.ok(monsters);
    }
}
