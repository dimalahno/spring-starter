package com.example;

import com.example.config.ApplicationConfiguration;
import com.example.database.pool.ConnectionPool;
import com.example.database.repository.CrudRepository;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

public class ApplicationRunner {
    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

//        try (var context = new ClassPathXmlApplicationContext("application.xml")){
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);
//        ConnectionPool pool2 = context.getBean("pool2", ConnectionPool.class);
            System.out.println("connectionPool = " + connectionPool);
//        System.out.println("pool2 = " + pool2);
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println("companyRepository = " + companyRepository.findById(1));
        }
    }
}
