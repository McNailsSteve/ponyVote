package de.stephannaegele.ponyVote.services;

import de.stephannaegele.ponyVote.builders.ItemBuilder;
import de.stephannaegele.ponyVote.domain.Item;
import de.stephannaegele.ponyVote.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ItemServiceTest {

    Item item;
    ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        itemService = new ItemService(itemRepository);

        item = new Item();
        item.setHeadline("Test");
        item.setDate(LocalDate.now());
    }

    @Test
    public void getItem() throws Exception {
        Long ITEMID = 4L;

        when(itemRepository.findById(ITEMID)).thenReturn(java.util.Optional.ofNullable(item));

        Item testItem = itemService.getItem(ITEMID);
        assertEquals(testItem.getId(), item.getId());

    }

    @Test
    public void getAllItems() throws Exception {

        final int NUMBER_OF_ITEMS = 4;

        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            items.add(new ItemBuilder().withRandomId().withDate(LocalDate.now()).withRandomTestHeadline().get());
        };

        when(itemRepository.findAll()).thenReturn(items);

        assertTrue(items.size() == 4);
    }

}