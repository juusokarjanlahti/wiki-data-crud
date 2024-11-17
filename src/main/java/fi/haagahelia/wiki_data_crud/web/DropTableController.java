package fi.haagahelia.wiki_data_crud.web;

import fi.haagahelia.wiki_data_crud.domain.DropTable;
import fi.haagahelia.wiki_data_crud.service.DropTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Controller
public class DropTableController {

    @Autowired
    private DropTableService dropTableService;

    @GetMapping("/droptable")
    public String getDropTableById(@RequestParam Long id, Model model) {
        try {
            DropTable dropTable = dropTableService.findById(id);
            model.addAttribute("droptable", dropTable);
            model.addAttribute("monsterName", dropTable.getMonster().getMonsterName());
            model.addAttribute("dropEntries", dropTable.getDropEntries());
            return "droptable";
        } catch (EntityNotFoundException e) {
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
        try {
            DropTable dropTable = dropTableService.findById(id);
            model.addAttribute("droptable", dropTable);
            return "droptableedit";
        } catch (EntityNotFoundException e) {
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