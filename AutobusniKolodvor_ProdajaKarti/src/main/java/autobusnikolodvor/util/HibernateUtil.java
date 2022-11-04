/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autobusnikolodvor.util;

import autobusnikolodvor.Start;
import java.io.File;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dino
 */
public class HibernateUtil {

    private static Session session = null;

    protected HibernateUtil() {
        // Exists only to defeat instantiation.
    }

    public static Session getSession() {
        if (session == null) {
            try {

                File direktorijJar = new File(
                        Start.class.getProtectionDomain().getCodeSource().getLocation().toURI());
                String hibConfigPath = direktorijJar.getParentFile() + File.separator + "hibernate.cfg.xml";
                if (hibConfigPath.contains("target")) {
                    session = new Configuration().configure().buildSessionFactory().openSession();
                } else {
                    File f = new File(hibConfigPath);
                    session = new Configuration().configure(f).buildSessionFactory().openSession();
                }

                session.setHibernateFlushMode(FlushMode.ALWAYS);
            } catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return session;
    }

    public static void reset() {
        session = null;
    }
}
