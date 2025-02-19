package com.secrets.testbed;

import java.util.Base64;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class SecretTestbed {
    private static final Logger logger = Logger.getLogger(SecretTestbed.class.getName());

    // Structured Tokens (Well-Defined Patterns)
    private static final String AWS_ACCESS_KEY = "AKIAIOSFODNN7EXAMPLE";
    private static final String GOOGLE_CLOUD_API_KEY = "AIzaSyD4t8-J3XZU0ExAmAEXAMPLEKEY";
    private static final String AZURE_SUBSCRIPTION_KEY = "d40e93bf-db23-4b88-a3b5-EXAMPLEKEY";
    private static final String GITHUB_PAT = "ghp_abcdefghijklmnopqrstuvwxyz123456";
    private static final String JWT_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VySWQiLCJleHAiOjE2MTYzMzcwMjJ9.2eQ4_3U5pO12345EXAMPLETOKEN";

    // Database Connection Strings
    private static final String POSTGRES_CONNECTION = "postgres://user:password@host:5432/database";
    private static final String MYSQL_CONNECTION = "jdbc:mysql://user:password@host:3306/database";
    private static final String MONGODB_CONNECTION = "mongodb://user:password@host:27017/database";

    public static void main(String[] args) throws IOException {
        // Unstructured Secrets (Hidden or Obfuscated)
        String concatenatedKey = "AIzaSyD4t" + "8-J3XZU0ExAm" + "AEXAMPLEKEY";
        logger.info("Concatenated API Key: " + concatenatedKey);

        // Base64 Encoded Secret
        String encodedSecret = Base64.getEncoder().encodeToString("sk_live_51H1EXAMPLE".getBytes());
        logger.info("Encoded Secret: " + encodedSecret);

        // Secrets Hidden in Logs
        logger.warning("User authenticated with token: " + JWT_TOKEN);

        // Hardcoded secrets in comments
        // API_KEY: "sk_test_51H1234EXAMPLE"
        
        // Create structured files for secrets
        Files.write(Paths.get("configs/application.properties"), ("api.key=" + GOOGLE_CLOUD_API_KEY).getBytes());
        Files.write(Paths.get("configs/secrets.env"), ("AWS_SECRET=" + AWS_ACCESS_KEY).getBytes());
        Files.write(Paths.get("logs/debug.log"), ("User logged in with token: " + JWT_TOKEN).getBytes());
        Files.write(Paths.get("db/database_config.yml"), ("database_url: " + POSTGRES_CONNECTION).getBytes());
        
        System.out.println("Testbed initialized with various secrets in structured files!");
    }
}
