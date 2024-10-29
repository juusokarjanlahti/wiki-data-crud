package fi.haagahelia.wiki_data_crud.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.domain.DropTableRepository;
import fi.haagahelia.wiki_data_crud.domain.Monster;
import fi.haagahelia.wiki_data_crud.domain.MonsterRepository;


@Controller
public class MonsterController {

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private DropTableRepository dropTableRepository;

    @GetMapping
    public List<Monster> getDropTable() {
        return monsterRepository.findAll();
    }

    @GetMapping(value = "/monsterlist")
    public String monsterList(Model model) {
        model.addAttribute("monsters", monsterRepository.findAll());
        return "monsterlist";
    }
    
}