package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.service.MonsterService;

@Controller
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/monsters")
    public String listAllMonsters(Model model) {
        model.addAttribute("monsters", monsterService.findAll());
        return "monsters";
    }

    @GetMapping("/monsteradd")
    public String newMonster(Model model) {
        model.addAttribute("monster", new Monster());
        return "monsteradd";
    }

    @PostMapping("/savemonster")
    public String saveMonster(@Valid @ModelAttribute Monster monster, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "monsteradd";
        }
        monsterService.save(monster);
        return "redirect:/monsters";
    }
}