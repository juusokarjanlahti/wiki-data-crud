package fi.haagahelia.wiki_data_crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import fi.haagahelia.wiki_data_crud.domain.DropEntry;
import fi.haagahelia.wiki_data_crud.service.DropEntryService;
import jakarta.validation.Valid;

@Controller
public class DropEntryController {

    @Autowired
    private DropEntryService dropEntryService;

    @GetMapping("/dropentries")
    public String listAllDropEntries(Model model) {
        model.addAttribute("dropentries", dropEntryService.findAll());
        return "dropentries";
    }

    @GetMapping("/dropentry")
    public String getDropEntryById(@RequestParam Long id, Model model) {
        Optional<DropEntry> dropEntry = dropEntryService.findById(id);
        if (dropEntry.isPresent()) {
            model.addAttribute("dropentry", dropEntry.get());
            return "dropentry";
        } else {
            return "redirect:/dropentries";
        }
    }

    // add dropentry form
    @GetMapping("/dropentryadd")
    public String newDropEntry() {
        return "dropentryadd";
    }

    // edit dropentry form
    @GetMapping("/dropentryedit")
    public String editDropEntry(@RequestParam Long id, Model model) {
        Optional<DropEntry> dropEntry = dropEntryService.findById(id);
        if (dropEntry.isPresent()) {
            model.addAttribute("dropentry", dropEntry.get());
            return "editdropentry";
        } else {
            return "redirect:/dropentries";
        }
    }

    @PostMapping("/savedropentry")
    public String saveDropEntry(@Valid @ModelAttribute DropEntry dropEntry, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dropentryadd";
        }
        dropEntryService.save(dropEntry);
        return "redirect:/dropentries";
    }

    @GetMapping("/deletedropentry")
    public String deleteDropEntry(@RequestParam Long id) {
        dropEntryService.deleteById(id);
        return "redirect:/dropentries";
    }
}