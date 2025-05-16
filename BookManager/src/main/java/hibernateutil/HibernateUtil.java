package hibernateutil;

import model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
       return new Configuration()
               .configure("hibernate.cfg.xml")
               .addAnnotatedClass(Book.class)
               .buildSessionFactory();
        }
        catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }//end of method

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutdown(){
        getSessionFactory().close();
    }


}
