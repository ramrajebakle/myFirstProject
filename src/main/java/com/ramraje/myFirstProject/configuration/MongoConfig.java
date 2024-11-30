//package com.ramraje.myFirstProject.configuration;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import lombok.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
//@EnableMongoRepositories(basePackages = "com.ramraje.myFirstProject.repository")
//public class MongoConfig {
//
//    String mongoUri = "mongodb+srv://ramrajebakle:Ramraje9860@cluster0.hqw4g.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
//
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create(mongoUri);  // Use the connection string from application.properties
//    }
//
//    @Bean
//    public MongoDatabaseFactory mongoDatabaseFactory() {
//        return new SimpleMongoClientDatabaseFactory(mongoClient(), "journaldb");  // Replace with your DB name
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoDatabaseFactory());
//    }
//}
