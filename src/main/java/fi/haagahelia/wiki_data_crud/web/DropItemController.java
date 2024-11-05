package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fi.haagahelia.wiki_data_crud.domain.DropItem;
import fi.haagahelia.wiki_data_crud.web.DropItemService;

@Controller
@RequestMapping("/dropitems")
public class DropItemController {

    @Autowired
    private DropItemService dropItemService;

    @GetMapping
    public String listDropItems(Model model) {
        model.addAttribute("dropItems", dropItemService.getAllDropItems());
        return "dropitemlist"; // The Thymeleaf template to list drop items
    }

    @GetMapping("/{id}")
    public String viewDropItem(@PathVariable Long id, Model model) {
        dropItemService.getDropItemById(id).ifPresent(dropItem -> model.addAttribute("dropItem", dropItem));
        return "dropitem"; // Template to view details of a single drop item
    }

    @PostMapping("/save")
    public String saveDropItem(DropItem dropItem) {
        dropItemService.saveDropItem(dropItem);
        return "redirect:/dropitems";
    }

    @GetMapping("/delete/{id}")
    public String deleteDropItem(@PathVariable Long id) {
        dropItemService.deleteDropItem(id);
        return "redirect:/dropitems";
    }

    @GetMapping("/dropitems/add")
    public String showAddDropItemForm(Model model) {
        model.addAttribute("dropItem", new DropItem()); // Creates a new, empty DropItem
        return "adddropitem"; // Renders the adddropitem.html template
    }

    @PostMapping("/dropitems/add")
    public String addDropItem(DropItem dropItem) {
        dropItemService.saveDropItem(dropItem);
        return "redirect:/dropitems";
    }
}
