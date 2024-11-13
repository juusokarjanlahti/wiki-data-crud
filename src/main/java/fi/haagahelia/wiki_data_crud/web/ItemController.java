package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import fi.haagahelia.wiki_data_crud.domain.Item;
import fi.haagahelia.wiki_data_crud.service.ItemService;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String listAllItems(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "items";
    }

    @GetMapping("/item")
    public String getItemById(@RequestParam Long id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "item";
        } else {
            return "redirect:/items";
        }
    }

    // add item form
    @GetMapping("/itemadd")
    public String newItem() {
        return "itemadd";
    }

    // edit item form
    @GetMapping("/itemedit")
    public String editItem(@RequestParam Long id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "edititem";
        } else {
            return "redirect:/items";
        }
    }

    @PostMapping("/saveitem")
    public String saveOrUpdateItem(Item item) {
        itemService.save(item);
        return "redirect:/items";
    }

    @DeleteMapping("/deleteitem")
    public String deleteItem(@RequestParam Long id) {
        itemService.deleteById(id);
        return "redirect:/items";
    }
}