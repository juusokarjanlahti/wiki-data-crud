package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
            return "droptable";
        } else {
            return "redirect:/droptables";
        }
    }

    // add droptable form
    @GetMapping("/droptableadd")
    public String newDropTable() {
        return "droptableadd";
    }

    // edit droptable form
    @GetMapping("/droptableedit")
    public String editDropTable(@RequestParam Long id, Model model) {
        Optional<DropTable> dropTable = dropTableService.findById(id);
        if (dropTable.isPresent()) {
            model.addAttribute("droptable", dropTable.get());
            return "editdroptable";
        } else {
            return "redirect:/droptables";
        }
    }

    @PostMapping("/savedroptable")
    public String saveOrUpdateDropTable(DropTable dropTable) {
        dropTableService.save(dropTable);
        return "redirect:/droptables";
    }

    @GetMapping("/deletedroptable")
    public String deleteDropTable(@RequestParam Long id) {
        dropTableService.deleteById(id);
        return "redirect:/droptables";
    }
}