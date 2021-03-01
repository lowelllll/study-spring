package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;

@Configuration
public class DbConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/lowell?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("lowell");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }
}
