package com.example;

import com.example.database.pool.ConnectionPool;
import com.example.database.repository.CompanyRepository;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.Map;

public class ApplicationRunner {
    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (var context = new ClassPathXmlApplicationContext("application.xml")){
            // context Map<String, Object>
//        System.out.println("context = " + context.getBean(ConnectionPool.class));
            ConnectionPool pool1 = context.getBean("pool1", ConnectionPool.class);
//        ConnectionPool pool2 = context.getBean("pool2", ConnectionPool.class);
            System.out.println("pool1 = " + pool1);
//        System.out.println("pool2 = " + pool2);
            CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println("companyRepository = " + companyRepository);
        }
    }
}
