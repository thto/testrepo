package com.t_systems_mms.basics;

import javax.persistence.*;
import java.util.List;

public class LandSprache {
    // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JavaTest");

    public LandSprache() {}

    public static void main(String[] args) {

        LandSprache landSprache = new LandSprache();

        landSprache.create(5, "Spanien", "spanisch");
        landSprache.create(6, "Schweiz", "deutsch");

        landSprache.upate(4, "Schottland", "schottisch");

        landSprache.delete(1);

        // Print all
        List<LandSpracheBean> allBeans = landSprache.readAll();
        if (allBeans != null) {
            for (LandSpracheBean landSpracheBean : allBeans) {
                System.out.println(landSpracheBean.toString());
            }
        }

        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }

    /**
     * create a new entry in db
     * @param id
     * @param land
     * @param sprache
     */
    public void create(int id, String land, String sprache) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new LandSpracheBean object
            LandSpracheBean landSpracheBean = new LandSpracheBean();
            landSpracheBean.setId(id);
            landSpracheBean.setLand(land);
            landSpracheBean.setSprache(sprache);

            // Save the LandSpracheBean object
            manager.persist(landSpracheBean);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Read all the LandSprachen.
     *
     * @return a List of Students
     */
    public List<LandSpracheBean> readAll() {

        //List landSprache = null;
        List<LandSpracheBean> landSprache = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            Query q = manager.createQuery("SELECT s FROM LandSpracheBean s",
                    LandSpracheBean.class);
            landSprache = q.getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return landSprache;
    }

    /**
     * Delete the existing Student.
     *
     * @param id
     */
    public void delete(int id) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            LandSpracheBean landSpracheBean = manager.find(LandSpracheBean.class, id);

            // Delete the student
            manager.remove(landSpracheBean);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Update the existing Student.
     *
     * @param id
     * @param land
     * @param sprache
     */
    public void upate(int id, String land, String sprache) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the object
            LandSpracheBean landSpracheBean = manager.find(LandSpracheBean.class, id);

            // Change the values
            landSpracheBean.setLand(land);
            landSpracheBean.setSprache(sprache);

            // Update
            manager.persist(landSpracheBean);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }
}
