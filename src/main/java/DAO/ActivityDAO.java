/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Model.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author KHOAPHAN
 */
public class ActivityDAO {
    public static int getTotalActivity(){
        Transaction transaction = null;
        List < Activity > listOfActivitysList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            System.out.println("Start load all Activity");
            String qr="from Activity ";
            listOfActivitysList = session.createQuery(qr).getResultList();
            System.out.println(listOfActivitysList.size());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
        if(listOfActivitysList==null){
            return 0;
        }
        else{
            return listOfActivitysList.size();
        }
    }
    public static List< Activity > getAllActivity(){
        Transaction transaction = null;
        List < Activity > listOfActivitysList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            System.out.println("Start load all Activity");
            String qr="from Activity ";
            listOfActivitysList = session.createQuery(qr).getResultList();
            System.out.println(listOfActivitysList.size());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
        return listOfActivitysList;
    }
    public static Activity getActivity(int id) {

        Transaction transaction = null;
        Activity at = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            at = (Activity) session.get(Activity.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return at;
    }
    
  
    
    public static void saveActivity(Activity activity) {
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(activity);
            System.out.println("Insert Sussess");
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
    }
    
    public static List < Activity > getAllActivitys(int userid) {

        Transaction transaction = null;
        List < Activity > listOfActivitys = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            System.out.println("Start load");
            String qr="from Activity where userid =:userid";
            listOfActivitys= session.createQuery(qr).setParameter("userid", userid).getResultList();
            System.out.println(listOfActivitys.size());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfActivitys;
    }
    
    public static void updateActivity(Activity at) { //edit toàn bộ các cột
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(at);
            System.out.println("Update Activity sussess");
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            System.err.println("that bai");
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public static void deleteActivity(int id) {

        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Activity at = (Activity)session.get(Activity.class, id);
            if (at != null) {
                session.delete(at);
                System.err.println("Delete success");
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    
    
    
    
    public static List < Routines > getAllRoutines(int userid) {

        Transaction transaction = null;
        List < Routines > listOfRoutines = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            System.out.println("Start load all Routines");
            String qr="from Routines where userid =:userid";
            listOfRoutines= session.createQuery(qr).setParameter("userid", userid).getResultList();
            System.out.println(listOfRoutines.size());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
        return listOfRoutines;
    }
    
}
