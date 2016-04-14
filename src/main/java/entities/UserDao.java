package entities;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UserDao {
    private static SessionFactory sessionFactory;
//    private static ServiceRegistry serviceRegistry;



//    static {
////        Configuration configuration = new Configuration();
//////        configuration.configure("hibernate.cfg.xml");
////
////        serviceRegistry = new ServiceRegistryBuilder().applySettings(
////                configuration.getProperties()). buildServiceRegistry();
////        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//        try {
//            sessionFactory = new Configuration().configure().
//                    buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }


    public User findUserByEmail(String email){

        if (email==null)
            return null;
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        User u=null;
        final Session session = sessionFactory.openSession();


        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM User WHERE email = :email";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            query.setParameter("email", email);
            u = (User)query.uniqueResult();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
//            throw e;
        } finally {
            session.close();
        }


        return u;
    }



    public void addUser(User user) {
        final Session session = sessionFactory.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
//            throw e;
        } finally {
            session.close();
        }
    }


    public void updatePassword(int id,String newPass) {
        final Session session = sessionFactory.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User u = (User)session.get(User.class, id );
            u.setPassword(newPass);
            session.update(u);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
//            throw e;
        } finally {
            session.close();
        }
    }


    public void deleteUser(int id) {
        final Session session = sessionFactory.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User u = (User)session.get(User.class, id );
            if (u==null)
                return;
            session.delete(u);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
//            throw e;
        } finally {
            session.close();
        }
    }
}







