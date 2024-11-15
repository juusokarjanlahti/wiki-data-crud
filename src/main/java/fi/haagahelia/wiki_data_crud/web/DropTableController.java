package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.service.DropTableService;

@Controller
public class DropTableController {

    @Autowired
    private DropTableService dropTableService;

    @GetMapping("/droptables")
    public String listAllDropTables(Model model) {
        model.addAttribute("droptables", dropTableService.findAll());
        return "droptables";
    }

    @GetMapping("/droptable")
    public String getDropTableById(@RequestParam Long id, Model model) {
        Optional<DropTable> dropTable = dropTableService.findById(id);
        if (dropTable.isPresent()) {
            model.addAttribute("droptable", dropTable.get());
            model.addAttribute("monsterName", dropTable.get().getMonster().getMonsterName());
            model.addAttribute("dropEntries", dropTable.get().getDropEntries());
            return "droptable";
        } else {
            return "redirect:/droptables";
        }
    }
}