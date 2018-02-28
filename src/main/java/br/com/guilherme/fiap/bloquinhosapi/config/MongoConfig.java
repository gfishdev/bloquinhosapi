package br.com.guilherme.fiap.bloquinhosapi.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private int mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Value("${spring.data.mongodb.username}")
    private String mongoUsername;

    @Value("${spring.data.mongodb.password}")
    private String mongoPassword;

    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }

//    @Override
    public Mongo mongo() throws Exception {
        //return new MongoClient(mongoHost, mongoPort);
        return new MongoClient(Collections.singletonList(new ServerAddress(mongoHost, mongoPort)),
                Collections.singletonList(MongoCredential.createCredential(mongoUsername, mongoDB, mongoPassword.toCharArray())));
    }

    @Override
    public MongoClient mongoClient() {
        //return new MongoClient(mongoHost, mongoPort);
        return new MongoClient(Collections.singletonList(new ServerAddress(mongoHost, mongoPort)),
                Collections.singletonList(MongoCredential.createCredential(mongoUsername, mongoDB, mongoPassword.toCharArray())));
    }
}
