package de.stephannaegele.ponyVote.controller;

import de.stephannaegele.ponyVote.commands.ItemFormView;
import de.stephannaegele.ponyVote.model.Item;
import de.stephannaegele.ponyVote.services.ItemService;
import de.stephannaegele.ponyVote.views.ItemView;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@Controller
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/item/new")
    public String showNewItem(Model model) {
        model.addAttribute("item", new ItemView());
        return "item/addEditItem";
    }

    @RequestMapping(value = "/item/")
    @PostMapping
    public String addItem(@ModelAttribute ItemFormView itemFormView) {
        ItemFormView savedItem = new ItemFormView(itemService.saveItem(itemFormView.mapTo()));
        return "redirect:/item/" + savedItem.getId();
    }

    @RequestMapping("/item/list")
    public String showAllItems(Model model) {
        List<Item> listOfAllItems = itemService.getAllItems();
        log.info("Retrieving " + listOfAllItems.size() + " sessionItems!");
        model.addAttribute("sessionItems", listOfAllItems);
        return "item/itemlist";
    }

    @RequestMapping(value = "/item/{itemId}")
    @GetMapping
    public String showItem(@PathVariable Long itemId, Model model) {
        model.addAttribute("item", itemService.getItem(itemId));
        return "item/addEditItem";
    }

//    @RequestMapping(value = "/item/{itemId}")
//    @PostMapping
//    public String editItem(@PathVariable Long itemId, Model model) {
//        Item editItem = itemService.saveItem(itemFormView.mapTo());
//        ItemFormView editedItem = new ItemFormView(editItem);
//        log.debug("item geändert");
//        return "redirect:/item/" + editedItem.getId();
//
//    }

}
