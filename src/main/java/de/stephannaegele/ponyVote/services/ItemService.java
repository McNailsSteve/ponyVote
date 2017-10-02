package de.stephannaegele.ponyVote.services;

import de.stephannaegele.ponyVote.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
