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
import model.organization_acount;

/**
 *
 * @author Smart
 */
public class CarsDao {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
  
      public static List searchCarByCarnumber(int car_number){
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
       try{
        tx=session.beginTransaction();
        
        String hql = "FROM Cars c WHERE c.car_number= :numberOfCar";
        Query query = session.createQuery(hql);
        query.setParameter("numberOfCar", car_number);
        results = query.list();
        tx.commit();
       }catch (HibernateException e) {
             if (tx != null) {
                 tx.rollback();
             }
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
    }
      
      public static List searchCarBytake_car(String take_car){
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
       try{
        tx=session.beginTransaction();
        
        String hql = "FROM Cars c WHERE c.take_car= :take_car";
        Query query = session.createQuery(hql);
        query.setParameter("take_car", take_car);
        results = query.list();
        tx.commit();
       }catch (HibernateException e) {
             if (tx != null) {
                 tx.rollback();
             }
             e.printStackTrace();
         } finally {
             session.close();
         }
        
        return results;
    }

    public static List searchCarByRetretiveCar(String RetretiveCar) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Cars c WHERE c.retretive_car= :retriveCar";
             Query query = session.createQuery(hql);
             query.setParameter("retriveCar", RetretiveCar);
             results = query.list();
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

    public static List searchCarByPriceperday(double PricePerday) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx=session.beginTransaction();
            String hql = "FROM Cars c WHERE c.price_perday = :pricePerday";
            Query query = session.createQuery(hql);
            query.setParameter("pricePerday", PricePerday);
            results = query.list();
            tx.commit();
        } catch (HibernateException e){
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }  
          
          return results;
     }
    public static List searchCarBycampany_name(String campany_name ){
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null; 
        tx=session.beginTransaction();
        String hql = "FROM Cars c WHERE c.campany_name = :campany_name";
        Query query = session.createQuery(hql);
        query.setParameter("campany_name",campany_name);
         results = query.list();
        tx.commit();  
        session.close(); 
        return results;
        
     }
     
    public static List searchCarBytype(String type ){
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null; 
        tx=session.beginTransaction();
        String hql = "FROM Cars c WHERE c.type = :type";
        Query query = session.createQuery(hql);
        query.setParameter("type",type);
         results = query.list();
        tx.commit();  
        session.close(); 
        return results;
        
     }
    public static List searchCarById(int id ){
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null; 
        try{
           
            tx=session.beginTransaction();
        String hql = "FROM Cars c WHERE c.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
         results = query.list();
        tx.commit(); }catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
             return results;
     }
     
    public  static void delete(int carId){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Cars cars = (Cars) session.get(Cars.class, carId);

            session.delete(cars);
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
    
    
    

    public static void insert(Cars car) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(car);
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
    
    public static void updateByreference(int carId ,Cars car){
        
        Session session = factory.openSession();
        Transaction tx = null;
        car=new Cars();
        try {
            tx = session.beginTransaction();
            Cars cars = (Cars) session.get(Cars.class, carId);
            cars=car;
            session.update(cars);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.getMessage();
        } finally {
            session.close();
        }
    }

    public static void update(int carId,organization_acount oc, String retretive_car, String owner_name, String type, String campany_name, String take_car, Double price_perday, String commit, int car_number, int organization_id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Cars cars = (Cars) session.get(Cars.class, carId);
            cars.setCampany_name(campany_name);
            cars.setCar_number(car_number);
            cars.setOwner_name(owner_name);
            cars.setCommit(commit);
           
            cars.setorganization_acount(oc);
            cars.setType(type);
            cars.setPrice_perday(price_perday);
            cars.setTake_car(take_car);
            cars.setRetretive_car(retretive_car);
            
            session.update(cars);
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
   
        

}
