package de.stephannaegele.ponyVote.services;

import de.stephannaegele.ponyVote.model.Item;
import de.stephannaegele.ponyVote.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item save(Item item) {

        return itemRepository.save(item);

    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).get();
    }

    public Set<Item> getAllItems() {
        return (Set<Item>) itemRepository.findAll();
    }
}
