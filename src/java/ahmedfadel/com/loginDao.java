/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmedfadel.com;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.Cars;
import model.login;

/**
 *
 * @author Smart
 */
public class loginDao {
     private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    
    
     public static List searchloginById(int Id  ){
         
         Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM login l WHERE l.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id",Id);
            results = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;   

    }
     public static List searchloginByName(String name  ){
         
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM login l WHERE l.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name",name);
            results = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;   

    }
  
    public  static void delete( int offerId){
      Session session = factory.openSession();
       Transaction tx = null;
      try{
         tx = session.beginTransaction();
         login loginn = (login)session.get(login.class, offerId); 
                   
         session.delete(loginn); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
    }
    
     public static void insert( login loginn){
     Session session = factory.openSession();
        Transaction tx = null;
        try{
        tx=session.beginTransaction();
        session.save(loginn);
        tx.commit();}
        catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      } 
   
     }
      
    
    
    

     
     public void update( int id,String name,String email,String password,String messages){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         login loginn = (login)session.get(login.class, id);
         loginn.setName(name);
         loginn.setMessages(messages);
         loginn.setEmail(email);
		 session.update(loginn); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
