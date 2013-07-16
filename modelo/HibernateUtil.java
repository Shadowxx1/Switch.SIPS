package modelo;

import logger.LoggerUtil;
import modelo.entidades.auditoria.AuditLogInterceptor;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.impl.SessionFactoryImpl;

/**
 * Hibernate Utility class with a convenient method 
 * to get Session Factory object.
 * @author Nelson Moncada
 * @author Nelson Moncada
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final SessionFactory sessionFactorySinIntercertor;
    private static final AnnotationConfiguration annotationConfiguration;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            annotationConfiguration = new AnnotationConfiguration().configure();
            sessionFactory = new AnnotationConfiguration().setInterceptor(AuditLogInterceptor.INSTANCE2).configure().buildSessionFactory();
            sessionFactorySinIntercertor = new AnnotationConfiguration().configure().buildSessionFactory();
//            AnnotationConfiguration a= new AnnotationConfiguration();
//            a.setInterceptor(AuditLogInterceptor.INSTANCE2);
//            sessionFactory=a.configure().buildSessionFactory();

        } catch (Exception ex) {
            LoggerUtil.error(HibernateUtil.class, "static", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static AnnotationConfiguration getAnnotationConfiguration() {
        return annotationConfiguration;
    }

    public static SessionFactoryImpl getSessionFactoryImpl() {
        return (SessionFactoryImpl) sessionFactory;
    }

    public static SessionFactory getSessionFactorySinIntercertor() {
        return sessionFactorySinIntercertor;
    }

//    private static final SessionFactory sessionFactory;
//    private static final AnnotationConfiguration annotationConfiguration;
//
//    static {
//        try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml)
//            // config file.
//            annotationConfiguration = new AnnotationConfiguration().configure();
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//        } catch (Exception ex) {
//            LoggerUtil.error(HibernateUtil.class, "static", ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static AnnotationConfiguration getAnnotationConfiguration() {
//        return annotationConfiguration;
//    }
//
//    public static SessionFactoryImpl getSessionFactoryImpl() {
//        return (SessionFactoryImpl) sessionFactory;
//    }
}
