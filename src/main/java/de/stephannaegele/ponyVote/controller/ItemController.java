package de.stephannaegele.ponyVote.controller;

import de.stephannaegele.ponyVote.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping("/items")
    public String getItem(Model model) {

        model.addAttribute("items", itemRepository.findAll());

        return "items";
    }
}
