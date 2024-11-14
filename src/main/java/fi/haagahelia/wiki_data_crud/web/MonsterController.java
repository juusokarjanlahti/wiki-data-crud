package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.service.MonsterService;

@Controller
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    // all monsters view
    @GetMapping("/monsters")
    public String monsters(Model model) {
        model.addAttribute("monsters", monsterService.findAll());
        return "monsters";
    }

    // monster view by id
    @GetMapping("/monster")
    public String monster(@RequestParam Long Id, Model model) {
        Optional<Monster> monster = monsterService.findById(Id);
        if (monster.isPresent()) {
            model.addAttribute("monster", monster.get());
            return "monster";
        } else {
            return "redirect:/monsters";
        }
    }

    // add monster form
    @PostMapping("/monsteradd")
    public String addMonster(Monster monster) {
        monsterService.save(monster);
        return "redirect:/monsters";
    }

    // edit monster form
    @PostMapping("/monsteredit")
    public String editMonster(@RequestParam Long id, Model model) {
        model.addAttribute("monster", monsterService.findById(id).orElse(new Monster()));
    return "redirect:/monsters";
    }

    // save monster
    @PostMapping("/savemonster")
    public String saveMonster(@ModelAttribute Monster monster) {
        monsterService.save(monster);
        return "redirect:/monsters";
    }

    // delete monster
    @PostMapping("/deletemonster")
    public String deleteMonster(@RequestParam Long id) {
        monsterService.deleteById(id);
        return "redirect:/monsters";
    }
}