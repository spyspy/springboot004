package com.springboot.config;

import com.springboot.dao.BaseDaoImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.springboot.dao", repositoryBaseClass = BaseDaoImpl.class)
public class DaoConfig {
    // additional JPA Configuration
}