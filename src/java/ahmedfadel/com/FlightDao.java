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
import model.organization_acount;

/**
 *
 * @author Smart
 */
public class FlightDao {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static List searchflightByfrom_to(String from_to) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();

            String hql = "FROM Flight f WHERE f.from_to = :from_to";
            Query query = session.createQuery(hql);
            query.setParameter("from_to", from_to);
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
    public static List searchfligtByarrival_time(String arrival_time) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();

            String hql = "FROM Flight f WHERE f.arrival_time = :arrival_time";
            Query query = session.createQuery(hql);
            query.setParameter("arrival_time", arrival_time);
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
    public static List searchfligtBydeparture_time(String departure_time) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();

            String hql = "FROM Flight f WHERE f.departure_time = :departure_time";
            Query query = session.createQuery(hql);
            query.setParameter("departure_time", departure_time);
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
    public static List searchflightBynum_seats(int num_seats) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();

            String hql = "FROM Flight f WHERE f.num_seats = :num_seats";
            Query query = session.createQuery(hql);
            query.setParameter("num_seats", num_seats);
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
    public static List searchflightByprice(int price) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();

            String hql = "FROM Flight f WHERE f.price = :price";
            Query query = session.createQuery(hql);
            query.setParameter("price", price);
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

    public static void delete(int flight_number) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Flight flight = (Flight) session.get(Cars.class, flight_number);

            session.delete(flight);
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

    public static void insert(Flight flight) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(flight);
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
    public static void updateByreference(int flight_number ,Flight flight){
        
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Flight f = (Flight) session.get(Cars.class, flight_number);
            f=flight;
            session.update(f);
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
    

    public  static void update(organization_acount oc,int flight_number, String arrival_time, String departure_time, int duration, String from_to, String places, int price, int num_seats, String bag_fees) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            Flight flight = (Flight) session.get(Cars.class, flight_number);
            flight.setArrival_time(arrival_time);
            flight.setDeparture_time(departure_time);
            flight.setDuration(duration);
            flight.setFrom_to(from_to);
          
            flight.setorganization_acount(oc);
            flight.setPlaces(places);
            flight.setPrice(price);
            flight.setNum_seats(num_seats);
            flight.setBag_fees(bag_fees);
            session.update(flight);
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
