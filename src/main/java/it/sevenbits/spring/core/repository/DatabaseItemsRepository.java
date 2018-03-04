package it.sevenbits.spring.core.repository;

import it.sevenbits.spring.core.model.Item;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseItemsRepository implements ItemsRepository {

    private JdbcOperations jdbcOperations;

    public DatabaseItemsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcOperations.query(
                "SELECT id, name FROM item",
                new RowMapper<Item>() {
                    public Item mapRow(ResultSet resultSet, int
                            i)
                            throws SQLException {
                        long id = resultSet.getLong(1);
                        String name = resultSet.getString(2);
                        return new Item(id, name);
                    }
                });
    }

    @Override
    public Item create(Item newItem) {
        long id = getNextId();
        // or generate UUID
        String name = newItem.getName();
        int rows = jdbcOperations.update(
                "INSERT INTO item (id, name) VALUES (?, ?)",
                id, name
        );
        return new Item(id, name); // or select from DB
    }

    @Override
    public Item getItemById(long id) {
        return jdbcOperations.queryForObject(
                "SELECT id, name FROM item WHERE id = ?",
                (resultSet, i) -> {
                    long rowId = resultSet.getLong(1);
                    String rowName = resultSet.getString(2);
                    return new Item(rowId, rowName);
                },
                id);
    }

    @Override
    public Item update(long id, Item newItem) {
        String name = newItem.getName();
        int rows = jdbcOperations.update("UPDATE item SET name = ? WHERE id = ?", name, id);
        return new Item(id, name); // or select from DB
    }

    @Override
    public boolean delete(long id) {
        int rows = jdbcOperations.update("DELETE FROM item WHERE id = ?", id);
        return rows > 0;
    }

    private long getNextId() {
        return jdbcOperations.queryForObject("select nextval('item_id_seq')", Long.class);
    }
}
