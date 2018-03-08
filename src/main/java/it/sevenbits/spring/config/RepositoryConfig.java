package it.sevenbits.spring.config;

import it.sevenbits.spring.core.repository.DatabaseItemsRepository;
import it.sevenbits.spring.core.repository.ItemsRepository;
import it.sevenbits.spring.core.repository.SampleItemsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

@Configuration
public class RepositoryConfig {

//    @Bean
//    public ItemsRepository itemsRepository() {
//        return new SampleItemsRepository();
//    }

    @Bean
    public ItemsRepository itemsRepository(@Qualifier("itemsJdbcOperations") JdbcOperations jdbcOperations) {
        return new DatabaseItemsRepository(jdbcOperations);
    }
}
