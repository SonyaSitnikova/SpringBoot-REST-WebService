package it.sevenbits.spring.core.repository;

import it.sevenbits.spring.core.model.Item;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_SampleItemsRepository {

    @Test
    public void test_getAllItems() {
        SampleItemsRepository sr = new SampleItemsRepository();
        List<Item> actual = sr.getAllItems();
        assertEquals(5, actual.size());
        assertEquals(1, actual.get(0).getId());
        assertEquals(2, actual.get(1).getId());
        assertEquals(3, actual.get(2).getId());
        assertEquals(4, actual.get(3).getId());
        assertEquals(5, actual.get(4).getId());
        assertEquals("First", actual.get(0).getName());
        assertEquals("Second", actual.get(1).getName());
        assertEquals("Third", actual.get(2).getName());
        assertEquals("Fourth", actual.get(3).getName());
        assertEquals("Fifth", actual.get(4).getName());
    }

    @Test
    public void test_getItemById() {
        SampleItemsRepository sr = new SampleItemsRepository();
        assertEquals("First", sr.getItemById(1).getName());
        assertEquals("Second", sr.getItemById(2).getName());
        assertEquals("Fourth", sr.getItemById(4).getName());
    }

    @Test
    public void test_create() {
        SampleItemsRepository sr = new SampleItemsRepository();
        Item newItem6 = new Item(6, "item6");
        Item newItem7 = new Item(7, "item7");
        sr.create(newItem6);
        sr.create(newItem7);
        assertEquals("item6", sr.getItemById(6).getName());
        assertEquals("item7", sr.getItemById(7).getName());
    }

    @Test
    public void test_update() {
        SampleItemsRepository sr = new SampleItemsRepository();
        sr.update(4, new Item(4, "testItemUpdated"));
        assertEquals("testItemUpdated", sr.getItemById(4).getName());
        sr.update(5, new Item(5, "Updated"));
        assertEquals("Updated", sr.getItemById(5).getName());
    }

    @Test
    public void test_delete() {
        SampleItemsRepository sr = new SampleItemsRepository();
        assertEquals(5, sr.getAllItems().size());
        assertTrue(sr.delete(2));
        assertEquals(null, sr.getItemById(2));
        assertEquals(4, sr.getAllItems().size());
        assertTrue(sr.delete(5));
        assertEquals(null, sr.getItemById(5));
        assertEquals(3, sr.getAllItems().size());
    }
}
