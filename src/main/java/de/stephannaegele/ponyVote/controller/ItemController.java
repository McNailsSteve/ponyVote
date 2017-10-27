package de.stephannaegele.ponyVote.controller;

import de.stephannaegele.ponyVote.repository.ItemRepository;
import de.stephannaegele.ponyVote.services.ItemService;
import de.stephannaegele.ponyVote.views.ItemView;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/items")
    public String getItems(Model model) {

        model.addAttribute("items", itemService.getAllItems());

        return "items";
    }

    @RequestMapping("/item/{itemId}")
    public String getItem(@PathVariable Long itemId, Model model) {
        ItemView view = new ItemView(itemService.getItem(itemId));
        model.addAttribute("item", view);

        return "item";
    }
}
