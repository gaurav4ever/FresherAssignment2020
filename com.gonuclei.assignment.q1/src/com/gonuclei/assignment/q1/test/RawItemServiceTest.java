package com.gonuclei.assignment.q1.test;


import com.gonuclei.assignment.q1.model.Item;
import com.gonuclei.assignment.q1.service.ItemService;
import com.gonuclei.assignment.q1.serviceImpl.RawItemService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RawItemServiceTest {

    @Test
    public void test() {
        ItemService itemService = new RawItemService();
        Item item = new Item();
        item.setName("Pencil");
        item.setQuantity(10);
        item.setType("raw");

        item.setPrice(100);
        Item matcherItem = itemService.calculateTax(item);
        assertEquals(12.5, matcherItem.getTax(), 0);

        item.setPrice(0);
        matcherItem = itemService.calculateTax(item);
        assertEquals(0, matcherItem.getTax(), 0);

    }

}
