package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // Instance unique de SessionFactory (Singleton)
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Chargement automatique de hibernate.cfg.xml dans src/main/resources
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Échec de la création de la SessionFactory : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Pour récupérer la sessionFactory depuis n’importe quel service
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Pour fermer proprement la SessionFactory (souvent à la fin du programme)
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
