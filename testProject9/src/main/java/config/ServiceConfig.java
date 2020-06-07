package config;

import dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.RegisterService;

@Configuration
public class ServiceConfig {

    @Autowired
    WordDao wordDao;

    @Bean
    public RegisterService registerService() {
        return new RegisterService(wordDao);
    }
}
