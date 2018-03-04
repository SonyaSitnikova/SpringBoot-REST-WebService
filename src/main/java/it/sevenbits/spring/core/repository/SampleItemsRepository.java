package it.sevenbits.spring.core.repository;

import it.sevenbits.spring.core.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SampleItemsRepository implements ItemsRepository {
    List<Item> items = new ArrayList<>();

    public SampleItemsRepository() {
        items.add(new Item(1, "First"));
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        items.add(new Item(4, "Fourth"));
        items.add(new Item(5, "Fifth"));
    }

    @Override
    public List<Item> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public Item create(Item newItem) {
        items.add(newItem);
        return newItem;
    }

    @Override
    public Item getItemById(long id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Item update(long id, Item newItem) {
        return items.set(items.indexOf(getItemById(id)), new Item(id,newItem.getName()));
    }

    @Override
    public boolean delete(long id) {
        return items.remove(getItemById(id));
    }
}