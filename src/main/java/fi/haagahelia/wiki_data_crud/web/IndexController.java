package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.service.MonsterService;

@Controller
public class IndexController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("monsters", monsterService.getAllMonsters());
        model.addAttribute("newMonster", new Monster());
        return "index";
    }
}