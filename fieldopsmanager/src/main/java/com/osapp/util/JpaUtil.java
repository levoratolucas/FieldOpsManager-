package com.osapp.util;


import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            try (InputStream input = JpaUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (input == null) {
                    throw new RuntimeException("Arquivo config.properties não encontrado no classpath.");
                }

                Properties props = new Properties();
                props.load(input);

                Map<String, Object> configOverrides = new HashMap<>();
                configOverrides.put("jakarta.persistence.jdbc.url", props.getProperty("db.url"));
                configOverrides.put("jakarta.persistence.jdbc.user", props.getProperty("db.user"));
                configOverrides.put("jakarta.persistence.jdbc.password", props.getProperty("db.password"));
                configOverrides.put("jakarta.persistence.jdbc.driver", "org.postgresql.Driver");

                emf = Persistence.createEntityManagerFactory("osappPU", configOverrides);

            } catch (IOException e) {
                throw new RuntimeException("Erro ao carregar config.properties", e);
            }
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
