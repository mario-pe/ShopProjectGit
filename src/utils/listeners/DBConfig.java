package utils.listeners; /**
 * Created by mario on 25.04.2017.
 */

import javax.persistence.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class DBConfig implements ServletContextListener{
    private static EntityManagerFactory emf;

    public static EntityManager createEntityManager(){
        if(emf != null)
            return emf.createEntityManager();
        else
            return null;
    }
    // Public constructor is required by servlet spec
    public DBConfig() {
    }

    public void contextInitialized(ServletContextEvent sce) {

        emf = Persistence.createEntityManagerFactory("PU");
    }

    public void contextDestroyed(ServletContextEvent sce) {

        if(emf != null)
            emf.close();
    }

}
