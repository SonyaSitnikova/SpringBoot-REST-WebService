package it.sevenbits.spring.core.repository;

import it.sevenbits.spring.core.model.User;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repository to list all users.
 */
public class DatabaseUsersRepository implements UsersRepository {
    private final JdbcOperations jdbcOperations;

    public DatabaseUsersRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public User findByUserName(String username) {
        return null;    // TODO
    }

    public List<User> findAll() {
        HashMap<String, User> users = new HashMap<>();

        for (Map<String, Object> row : jdbcOperations.queryForList(
                "SELECT username, authority FROM authorities a" +
                        " WHERE EXISTS" +
                        " (SELECT * FROM users u WHERE" +
                        " u.username = a.username AND u.enabled = true)")) {

            String username = String.valueOf(row.get("username"));
            String newRole = String.valueOf(row.get("authority"));
            User user = users.computeIfAbsent(username, name -> new User(name, new ArrayList<>()));
            List<String> roles = user.getAuthorities();
            roles.add(newRole);

        }

        List<User> result = new ArrayList<>();
        result.addAll(users.values());
        return result;
    }

}