package com.example.config;

import com.example.database.pool.ConnectionPool;
import com.example.database.repository.UserRepository;
import com.example.web.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration
public class ApplicationConfiguration {

    @Bean("pool2")
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 25);
    }

    @Bean
    @Profile("prod|web")
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository3() {
        ConnectionPool connectionPool1 = pool3();
        ConnectionPool connectionPool2 = pool3();
        ConnectionPool connectionPool3 = pool3();
        return new UserRepository(pool3());
    }
}
