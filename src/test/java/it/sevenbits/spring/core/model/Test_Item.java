package it.sevenbits.spring.core.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Test_Item {

    @Test
    public void testItemName() throws Exception {
        Item item1 = new Item(1, "firstItem");
        assertEquals("firstItem", item1.getName());
        Item item2 = new Item(2, "secondItem");
        assertEquals("secondItem", item2.getName());
        Item item3 = new Item(3, "thirdItem");
        assertEquals("thirdItem", item3.getName());
    }
    @Test
    public void testItemId() throws Exception {
        Item item1 = new Item(4, "fourthItem");
        assertEquals(4, item1.getId());
        Item item2 = new Item(5, "secondItem");
        assertEquals(5, item2.getId());
        Item item3 = new Item(6, "thirdItem");
        assertEquals(6, item3.getId());
    }

    @Test
    public void testItemIdName() throws Exception {
        Item item1 = new Item(7, "Items");
        assertEquals(7, item1.getId());
        assertEquals("Items", item1.getName());

        Item item2 = new Item(8, "ItemsItems");
        assertEquals(8, item2.getId());
        assertEquals("ItemsItems", item2.getName());

        Item item3 = new Item(9, "Items9");
        assertEquals(9, item3.getId());
        assertEquals("Items9", item3.getName());
    }
}
