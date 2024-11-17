package fi.haagahelia.wiki_data_crud.web;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.service.DropTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@Controller
public class DropTableController {

    @Autowired
    private DropTableService dropTableService;

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

    @GetMapping("/droptableadd")
    public String newDropTable(Model model) {
        model.addAttribute("droptable", new DropTable());
        return "droptableadd";
    }

    @PostMapping("/savedroptable")
    public String saveDropTable(@Valid @ModelAttribute DropTable dropTable, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "droptableadd";
        }
        dropTableService.save(dropTable);
        return "redirect:/droptables";
    }

    @GetMapping("/droptableedit")
    public String editDropTable(@RequestParam Long id, Model model) {
        Optional<DropTable> dropTable = dropTableService.findById(id);
        if (dropTable.isPresent()) {
            model.addAttribute("droptable", dropTable.get());
            return "droptableedit";
        } else {
            return "redirect:/droptables";
        }
    }

    @PostMapping("/updatedroptable")
    public String updateDropTable(@Valid @ModelAttribute DropTable dropTable, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "droptableedit";
        }
        dropTableService.save(dropTable);
        return "redirect:/droptables";
    }
}