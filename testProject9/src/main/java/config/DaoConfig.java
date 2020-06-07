package config;

import dao.WordDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public WordDao wordDao() {
        return new WordDao();
    }
}
