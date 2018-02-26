package it.sevenbits.spring.config;

import it.sevenbits.spring.core.repository.ItemsRepository;
import it.sevenbits.spring.core.repository.SampleItemsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public ItemsRepository itemsRepository() {
        return new SampleItemsRepository();
    }
}
