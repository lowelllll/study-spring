package config;

import dao.WordDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.RegisterService;

@Configuration
public class Config {

    @Bean
    public WordDao wordDao() {
        return new WordDao();
    }

    @Bean
    public RegisterService registerService() {
        return new RegisterService();
    }
}
