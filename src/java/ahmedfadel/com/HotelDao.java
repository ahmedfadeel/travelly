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
import model.Flight;
import model.Hotel;
import model.offer;
import model.organization_acount;

/**
 *
 * @author Smart
 */
public class HotelDao {
    
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
  
    
      public static List<Hotel> searchHotelByLocation( String location ){
        Session session = factory.openSession();
        Transaction tx = null; 
        List results=null;
         try{
          tx=session.beginTransaction();
          String hql = "FROM Hotel h WHERE h.location = :location";
          Query query = session.createQuery(hql);
          query.setParameter("location",location);
          results = query.list();
         tx.commit();
         }catch(HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
     }
      public static List<Hotel> searchHotelByprice( double price){
        Session session = factory.openSession();
        Transaction tx = null;
        List results=null;
        try{
          tx=session.beginTransaction();
          String hql = "FROM Hotel h WHERE h.price = :price";
            Query query = session.createQuery(hql);
            query.setParameter("price", price);
            results = query.list();
            tx.commit();
        }catch(HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return results;
       
      }
       public  static List<Hotel>  searchHotelByname( String Name ){
        Session session = factory.openSession();
        Transaction tx = null;
        List results=null;
        try{
          tx=session.beginTransaction();
          String hql = "FROM Hotel h WHERE h.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", Name);
            results = query.list();
            tx.commit();
        }catch(HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return results;
       
       }
    public  static void delete( int id){
      Session session = factory.openSession();
       Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Hotel hotel = (Hotel)session.get(Hotel.class, id); 
                   
         session.delete(hotel); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
    }
    
     public static void insert( Hotel hotel){
     Session session = factory.openSession();
       Transaction tx = null;
        try{
         tx = session.beginTransaction();
        session.save(hotel);
        tx.commit();}
        catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      } 
   
     }
      
    
    
   
     public static void updateByreference(int id , Hotel h ){
        
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
             Hotel hotel = (Hotel)session.get(Hotel.class, id); 
              hotel =h;
            session.update(hotel);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
     
     public void update( organization_acount oc ,int id,int rooms,int adults,int price,int children, String name,String address, String arrival_time,String location){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
          Hotel hotel = (Hotel)session.get(Hotel.class, id); 
            hotel.setRooms(rooms);
            hotel.setAdults(adults);
            hotel.setPrice(price);
            hotel.setChildren(children);
            hotel.setName(name);
            hotel.setAddress(address);
           
            hotel.setorganization_acount(oc);
            hotel.setArrival_time(arrival_time);
            hotel.setLocation(location);
		 session.update(hotel); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
 
}
