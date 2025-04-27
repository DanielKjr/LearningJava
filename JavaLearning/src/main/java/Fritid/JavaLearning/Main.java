package Fritid.JavaLearning;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        removeClutter();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("local");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            var query = em.createQuery("SELECT b FROM BasicClass b", BasicClass.class);

            var results = query.getResultList();



            System.out.println("Results size: " + results.size());

            for (BasicClass basicClass : results) {
                System.out.println("BasicClass TestField: " + basicClass.getTestField());

//                for (BasicEntry entry : basicClass.getBasicEntries()) {
//                    System.out.println("BasicEntry ID: " + entry.getId());
//                }
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }


    private static void removeClutter() {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("JavaLearning/src/main/resources/logging.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}