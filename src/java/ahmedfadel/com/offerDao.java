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
import model.login;
import model.offer;

/**
 *
 * @author Smart
 */
public class offerDao {
    
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static final Session session = factory.openSession();
    private static final Transaction tx = session.beginTransaction();
    
    public List searchOfferByType( String Type ){
         
            String hql = "FROM offer of WHERE of.TYPE = :type";
        Query query = session.createQuery(hql);
        query.setParameter("type",Type);
        List results = query.list();
        return results;
     }
       public List searchOfferByPrice( int price ){
         
            String hql = "FROM offer of WHERE of.price = :Price";
        Query query = session.createQuery(hql);
        query.setParameter("PRICE",price);
        List results = query.list();
        return results;
     }
    public  static void delete( int id){
      Session session = factory.openSession();
       Transaction tx = null;
      try{
         tx = session.beginTransaction();
         offer offerr = (offer)session.get(offer.class, id); 
                   
         session.delete(offerr); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
    }
    
     public static void insert(offer offerr){
     Session session = factory.openSession();
       Transaction tx = null;
        try{
         tx = session.beginTransaction();
        session.save(offerr);
        tx.commit();}
        catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      } 
   
     }
      
    
    
    
    
    
  
     
     public void update(int id,String type,String detail,int price){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
          offer offerr = (offer)session.get(offer.class, id); 
          offerr.setPrice(price); 
          offerr.setDetail(detail); 
          offerr.setType(type); 
		 session.update(offerr); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
