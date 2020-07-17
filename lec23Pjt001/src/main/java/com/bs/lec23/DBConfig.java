package com.bs.lec23;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
public class DBConfig {

    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost/lowell?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setMaxPoolSize(10);
        dataSource.setCheckoutTimeout(60000);

        return dataSource;
    }
}
