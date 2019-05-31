package jpa;

import model.Login;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


public class LoginEntityManager extends JpaEntityManager<Integer, Login> {

    public Login findByLoginAndPassword(String login, String password){
        EntityManager entityManager= null;
        try{
            entityManager=getEntityManagerFactory().createEntityManager();
            return (Login) entityManager.createQuery("select a from Login a where a.login =:login and a.password ="+":password").setParameter("login",login).setParameter("password",password).getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch (Exception e){

        }finally {
            entityManager.close();
        }
        return null;
    }
}

