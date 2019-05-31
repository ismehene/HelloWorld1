package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class JpaEntityManager<K, E> implements jpa.BaseEntitymanager<K, E> {


    protected Class<E> entityClass;

    protected EntityManagerFactory entityManagerFactory = null;


    public EntityManagerFactory getEntityManagerFactory() {
        try {
            if (entityManagerFactory == null)
                entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
            return entityManagerFactory;
        }catch (Exception e){
            e.printStackTrace();

            return null;
        }
    }

    public JpaEntityManager() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }


    public List<E> findAll() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            return entityManager.createQuery("select p from " + entityClass.getSimpleName() + " p").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    public boolean add(E entity) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            // Get a transaction
            transaction = entityManager.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Save the object
            entityManager.persist(entity);
            // Commit the transaction
            transaction.commit();
            return true;
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            // Print the Exception
            return false;
        } finally {
            // Close the EntityManager
            entityManager.close();
        }
    }


    public boolean delete(E entity) {
        // Create an EntityManager
        EntityManager entityManager = null;

        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            // Get a transaction
            transaction = entityManager.getTransaction();
            // Begin the transaction
            transaction.begin();
            // remove the object
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            // Commit the transaction
            transaction.commit();
            return true;
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            return false;
        } finally {
            // Close the EntityManager
            entityManager.close();
        }
    }


    public E findById(K id) {
        E entity;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            // Get a transaction
            transaction = entityManager.getTransaction();
            // Begin the transaction
            transaction.begin();
            // find the object
            entity = entityManager.find(entityClass, id);
            // Commit the transaction
            transaction.commit();
            return entity;
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            // Close the EntityManager
            entityManager.close();
        }
        return null;
    }


    public boolean update(E entity) {
        EntityManager entityManager = null;

        EntityTransaction transaction = null;
        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            // Get a transaction
            transaction = entityManager.getTransaction();

            // Begin the transaction
            transaction.begin();
            // Update the object
            entityManager.merge(entity);
            // Commit the transaction1
            transaction.commit();
            return true;
        } catch (Exception e) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            return false;
        } finally {
            entityManager.close();
        }
    }
}
