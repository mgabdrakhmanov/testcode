package ru.marat.springdemo.helloworld.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.marat.springdemo.helloworld")
@EnableWebMvc
public class TestConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public TestConfig(ApplicationContext aContext) {
        applicationContext = aContext;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test-db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public InternalResourceViewResolver templateResolver() {
        InternalResourceViewResolver templateResolver = new InternalResourceViewResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/Views/");
        //templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(templateResolver());
    }

}
