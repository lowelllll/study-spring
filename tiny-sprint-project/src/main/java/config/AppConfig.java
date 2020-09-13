package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
public class AppConfig {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(); // 싱글톤
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

}
