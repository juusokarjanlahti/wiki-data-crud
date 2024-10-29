package fi.haagahelia.wiki_data_crud.web;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.wiki_data_crud.domain.Monster;

@Controller
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/monsters/{id}")
    public String getMonster(@PathVariable Long id, Model model) {
        Optional<Monster> monster = monsterService.getMonsterWithDropTables(id);
        if (monster.isPresent()) {
            model.addAttribute("monster", monster.get());
            return "monster";
        } else {
            return "monster-not-found";
        }
    }
}