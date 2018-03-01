package it.sevenbits.spring.web.controllers;

import it.sevenbits.spring.core.model.Item;
import it.sevenbits.spring.core.repository.ItemsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private ItemsRepository itemsRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Item> list() {
        return itemsRepository.getAllItems();
    }
    public ItemsController(final ItemsRepository itemsRepository) {
    this.itemsRepository = itemsRepository;
}
}
