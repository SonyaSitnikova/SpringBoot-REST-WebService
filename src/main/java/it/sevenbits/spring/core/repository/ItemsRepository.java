package it.sevenbits.spring.core.repository;

import it.sevenbits.spring.core.model.Item;

import java.util.List;

public interface ItemsRepository {

    List<Item> getAllItems();
}
