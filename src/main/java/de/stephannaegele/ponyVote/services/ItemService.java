package de.stephannaegele.ponyVote.services;

import de.stephannaegele.ponyVote.domain.Item;
import de.stephannaegele.ponyVote.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItem(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.isPresent()?itemOptional.get():new Item();
    }

    public Set<Item> getAllItems() {
        return (Set<Item>) itemRepository.findAll();
    }

    public Item saveItem(Item item) {
        log.debug("Saving Item " + item.getHeadline());
        return itemRepository.save(item);
    }
}
