package com.zohra.microservice_temperature.config;

import com.datastax.oss.driver.api.core.CqlSession;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;

import java.net.InetSocketAddress;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.cassandra.keyspace-name}")
    private String keyspaceName;

    @Value("${spring.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.cassandra.port}")
    private int port;

    @Value("${spring.cassandra.local-datacenter}")
    private String localDatacenter;

    @Value("${spring.cassandra.username}")
    private String username;

    @Value("${spring.cassandra.password}")
    private String password;

    @PostConstruct
    public void checkProperties() {
        System.out.println("Cassandra Keyspace Name: " + keyspaceName);
        System.out.println("Cassandra Contact Points: " + contactPoints);
        System.out.println("Cassandra Port: " + port);
        System.out.println("Cassandra Local Datacenter: " + localDatacenter);
        System.out.println("Cassandra Username: " + username);
        System.out.println("Cassandra Password: " + password);
    }
    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cassandraSession = super.cassandraSession();
        cassandraSession.setKeyspaceName(keyspaceName);
        cassandraSession.setContactPoints(contactPoints);
        cassandraSession.setPort(port);
        cassandraSession.setLocalDatacenter(localDatacenter);
        cassandraSession.setUsername(username);
        cassandraSession.setPassword(password);
        return cassandraSession;
    }
}
