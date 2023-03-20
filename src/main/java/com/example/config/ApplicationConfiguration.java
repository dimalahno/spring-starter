package com.example.config;

import com.example.database.repository.CrudRepository;
import com.example.web.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example",
        useDefaultFilters = false,
includeFilters = {
    @Filter(type = FilterType.ANNOTATION, value = Component.class),
    @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
    @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
})
public class ApplicationConfiguration {


}
