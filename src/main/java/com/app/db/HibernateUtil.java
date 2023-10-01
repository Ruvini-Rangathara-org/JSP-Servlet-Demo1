package com.app.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Properties;

public class HibernateUtil {

    // Create a static SessionFactory variable to hold the Hibernate SessionFactory.
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    // A private method to build the Hibernate SessionFactory.
    private static SessionFactory buildSessionFactory() {
        // Create a Properties object to load Hibernate properties.
        Properties properties = new Properties();

        try {
            // Load Hibernate properties from a file named "hibernate.properties" on the classpath.
            properties.load(HibernateUtil.class.getClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a StandardServiceRegistry to configure Hibernate settings.
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build();

        // Create MetadataSources and build Metadata with a JPA-compliant naming strategy.
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        // Build and return the SessionFactory.
        return metadata.getSessionFactoryBuilder().build();
    }

    // Getter method to access the SessionFactory.
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
