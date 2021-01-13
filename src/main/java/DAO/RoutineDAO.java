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
 * @author ASUS
 */
public class RoutineDAO {
    public static List<Routines> getAllRoutineses(int id) {
            Transaction transaction = null;
            List<Routines> listOfrt = null;
            System.out.println("load routine");
            String query = "from Routines where userid = :user";
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            try {
                    transaction = session.beginTransaction();
                    listOfrt = session.createQuery(query).setParameter("user", id).getResultList();
                    transaction.commit();
            } catch (Exception e) {
                    if (transaction != null) {
                            transaction.rollback();session.close();
                    }
                    e.printStackTrace();session.close();
            }
            return listOfrt;
	}
    public static Routines getRoutine(int id) {

        Transaction transaction = null;
        Routines td = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            td = (Routines) session.get(Routines.class, id);
            // commit transaction
            transaction.commit();session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();session.close();
            }
        }
        return td;
    }
    public static List<Activity> getActivitys(int id){
        Transaction transaction = null;
        List<Activity> listOfrt = null;
        System.out.println("load routine");
        String query = "from Activity where routineid = :id";
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
                transaction = session.beginTransaction();
                listOfrt = session.createQuery(query).setParameter("id", id).getResultList();
                transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                    transaction.rollback();session.close();
            }
            e.printStackTrace();
        }
        if(listOfrt!=null){
            System.out.println(listOfrt.size());session.close();
        }
        return listOfrt;
    }
    public static void updateRoutine(Routines rt) { 
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("alo alo alo");
        try  {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(rt);
            System.out.println("Update rt sussess");
            // commit transaction
            transaction.commit();session.close();
        } catch (Exception e) {
            System.out.println("That bai");
            if (transaction != null) {
                transaction.rollback();session.close();
            }
        }
    }
    public static void deleteRoutine(int id) {

        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Routines td = (Routines)session.get(Routines.class, id);
            if (td != null) {
                session.delete(td);
                System.err.println("Delete success");
            }
            // commit transaction
            transaction.commit();session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();session.close();
            }
        }
    }
    public static void saveRoutine(Routines rt) {
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(rt);
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
}
