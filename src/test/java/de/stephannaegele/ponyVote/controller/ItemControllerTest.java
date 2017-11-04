package de.stephannaegele.ponyVote.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import de.stephannaegele.ponyVote.builders.ItemBuilder;
import de.stephannaegele.ponyVote.domain.Item;
import de.stephannaegele.ponyVote.repository.ItemRepository;
import de.stephannaegele.ponyVote.services.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ItemControllerTest {

    @Mock
    private ItemService itemService;
    @Mock
    Model model;

    private ItemController itemController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        itemController = new ItemController(itemService);
    }

    @Test
    public void getItem() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();

        final Long TEST_ITEM_ID = 4L;

        when(itemService.getItem(TEST_ITEM_ID)).thenReturn(
                new ItemBuilder().withId(TEST_ITEM_ID).withDateToday().withRandomTestHeadline().get());


        mockMvc.perform(get("/item/" + TEST_ITEM_ID.toString()))
                .andExpect(status().isOk())
                .andExpect(view().name("item/addEditItem"));

    }

    @Test
    public void getAllItems() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();

        final int TEST_ITEM_LIST_SIZE = 5;

        ArrayList<Item> itemList = new ArrayList<>();

        for (int i = 0; i < TEST_ITEM_LIST_SIZE; i++) {
            itemList.add(new ItemBuilder().withRandomId().withRandomTestHeadline().withDateToday().get());
        }
        when(itemService.getAllItems()).thenReturn(itemList);

        mockMvc.perform(get("/item/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("item/itemlist"))
                .andExpect(model().attributeExists("sessionItems"));

        verify(itemService, times(1)).getAllItems();
    }
}