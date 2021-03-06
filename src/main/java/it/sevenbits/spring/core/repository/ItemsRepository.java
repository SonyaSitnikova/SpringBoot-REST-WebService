package it.sevenbits.spring.core.repository;

import it.sevenbits.spring.core.model.Item;

import java.util.List;

public interface ItemsRepository {

    List<Item> getAllItems();

    Item create(Item newItem);

    Item getItemById(long id);

    Item update(long id, Item newItem);

    boolean delete(long id);
}
