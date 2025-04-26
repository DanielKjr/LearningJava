package Fritid.JavaLearning;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("local");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            var query = em.createQuery("SELECT b FROM BasicClass b", BasicClass.class);

            var results = query.getResultList();

            System.out.println("Results size: " + results.size());

            for (BasicClass basicClass : results) {
                System.out.println("BasicClass ID: " + basicClass.getId());

                for (BasicEntry entry : basicClass.getBasicEntries()) {
                    System.out.println("BasicEntry ID: " + entry.getId());
                }
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
}