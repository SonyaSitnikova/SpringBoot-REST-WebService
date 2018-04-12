package it.sevenbits.spring.core.repository;

import it.sevenbits.spring.core.model.User;

import java.util.List;

public interface UsersRepository {

    User findByUserName(String username);

    List<User> findAll();

}
