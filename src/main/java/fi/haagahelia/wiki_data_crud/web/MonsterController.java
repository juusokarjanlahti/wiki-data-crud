package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;

import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;

@Controller
public class MonsterController {

    @Autowired
    private MonsterRepository monsterRepository;

    // listAllMonsters(Model model)
    // fetch all monsters and return the view for display
    @GetMapping(value = "/monsterlist")
    public String listAllMonsters(Model model) {
    model.addAttribute("monsterlist", monsterRepository.findAll());
    return "monsterlist";
    }

    // save(Monster monster)
    // save monster to repository
    @PostMapping(value = "/save")
    public String save(Monster monster) {
        monsterRepository.save(monster);
        return "redirect:monsterlist";
    }

    // showAddMonsterForm(Model model)
    // return the form for adding a new monster
    @GetMapping(value = "/addmonster")
    public String showAddMonsterForm(Model model) {
    model.addAttribute("monster", new Monster());
    return "addmonster";
    }

    // viewMonster(Long id, Model model)
    @GetMapping(value = "/monster/{id}")
    public String viewMonster(@PathVariable("id") Long id, Model model) {
        Optional<Monster> monster = monsterRepository.findById(id);
        model.addAttribute("monster", monster.get());
        return "monster";
    }   


    // showEditMonsterForm(Long id, Model model)
    @GetMapping(value = "/edit/{id}")
    public String showEditMonsterForm(@PathVariable("id") Long id, Model model) {
    Optional<Monster> monster = monsterRepository.findById(id);
    model.addAttribute("monster", monster.get());
    return "editmonster";
    }

    // updateMonster(Monster monster)
    @PostMapping(value = "/update")
    public String updateMonster(Monster monster) {
        monsterRepository.save(monster);
    return "redirect:/monsterlist";
}


    // deleteMonster(Long id)
    @GetMapping(value = "/delete/{id}")
    public String deleteMonster(@PathVariable("id") Long id) {
        monsterRepository.deleteById(id);
        return "redirect:/monsterlist";
    }
}