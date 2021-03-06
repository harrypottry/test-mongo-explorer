package com.test.mongo.explorer.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 */
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.depot")
public class DepotMongoConfig extends AbstractMongoConfig {

    public static final String MONGO_TEMPLATE = "depotMongoTemplate";

    @Bean(name = MONGO_TEMPLATE)
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}