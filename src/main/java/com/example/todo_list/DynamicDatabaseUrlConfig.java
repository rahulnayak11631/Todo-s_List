package com.example.todo_list;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class DynamicDatabaseUrlConfig {

    @Bean
    public CommandLineRunner setDbHost() {
        return args -> {
            String ipAddress = getIpAddress();
            System.setProperty("DB_HOST", ipAddress);

            // Additional startup logic if needed
        };
    }

    private String getIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException("Failed to fetch the IP address", e);
        }
    }
}