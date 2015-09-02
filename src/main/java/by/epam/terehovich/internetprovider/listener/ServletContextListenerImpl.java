package by.epam.terehovich.internetprovider.listener;

import by.epam.terehovich.internetprovider.connection.ConnectionPool;
import by.epam.terehovich.internetprovider.exception.PoolException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by aterehovich on 9/2/15.
 */
@WebListener
public class ServletContextListenerImpl implements ServletContextListener{

    private final static Logger LOGGER = Logger.getLogger(ServletContextListenerImpl.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        System.setProperty("rootPath", context.getRealPath("/"));
        new DOMConfigurator().doConfigure(System.getProperty("rootPath")+"log4j.xml", LogManager.getLoggerRepository());

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            pool.closeAll();
        } catch (PoolException e) {
            LOGGER.error("Unable to close pool: " + e.getMessage());
        }
    }
}
