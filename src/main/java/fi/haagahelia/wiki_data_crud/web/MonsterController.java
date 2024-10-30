package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

import fi.haagahelia.wiki_data_crud.domain.DropTableRepository;
import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MonsterController {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private DropTableRepository dropTableRepository;

    @RequestMapping(value = "/monsterlist")
    public String list(Model model) {
        model.addAttribute("monsters", monsterRepository.findAll());
        return "monsters";
    }

    @RequestMapping(value = "/monsters", method=RequestMethod.GET)
    public @ResponseBody Optional<Monster> findMonsterRest(@RequestParam("id") Long monster_id) {	
        return monsterRepository.findById(monster_id);
    }
    

    @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("monster", new Monster());
        model.addAttribute("dropTable", dropTableRepository.findAll());
        return "addmonster";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Monster monster) {
        monsterRepository.save(monster);
        return "redirect:monsters";
    }

    @RequestMapping(value = "/delete/{monster_id}", method = RequestMethod.GET)
    public String deleteMonster(@PathVariable("monster_id") Long monster_id, Model model) {
        monsterRepository.deleteById(monster_id);
        return "redirect:../monsters";
    }

    @RequestMapping("/monsters/{monster_id}")
    public String view(@PathVariable Long monster_id, Model model) {
        Optional<Monster> monster = monsterRepository.findById(monster_id);
        if (monster.isPresent()) {
            model.addAttribute("monster", monster.get());
            return "monster";
        } else {
            return "monster-not-found";
        }
    }
}