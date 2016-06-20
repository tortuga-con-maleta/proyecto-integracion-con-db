/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Pablo de la Sotta
 */
public class DbConnect {
    private static EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("JPAPU");

    public static void insertar(Object obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    public static void modificar(Object o) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    public Object buscarPorId(Class clazz, Integer id) {
        EntityManager em = emf.createEntityManager();
        Object o = em.find(clazz, id);
        em.close();
        return o;
    }

    public static void eliminar(Class clazz, Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Object o = em.find(clazz, id);
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
    }
    
    public static List<? extends Object> buscarPorQuery(
            String query, Map<String, Object> parametros){
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNamedQuery(query);
            
            if (parametros != null){
                for (Map.Entry<String, Object> param : 
                        parametros.entrySet()){
                    q.setParameter(param.getKey(), 
                            param.getValue());
                }
            }
            List ret = q.getResultList();
    
            return ret;
        } catch (Exception e){
        } finally {
            em.close();
        }
        return null;
    }
}
