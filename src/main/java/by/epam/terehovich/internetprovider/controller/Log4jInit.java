package by.epam.terehovich.internetprovider.controller;

import by.epam.terehovich.internetprovider.connection.ConnectionPool;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by aterehovich on 16.7.15.
 */
@WebServlet(name = "Log4jInit", loadOnStartup = 1,
            initParams = @WebInitParam(
                    name = "logFileInit", value = "main/resources/log4j.properties"
            ))
public class Log4jInit extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        String log4jLocation = config.getInitParameter("logFileInit");
        String pref = getServletContext().getRealPath("/");
        PropertyConfigurator.configure(pref + log4jLocation);
        Logger globallog = Logger.getRootLogger();
        globallog.info("Application has been started, Logger has been initialized");
        getServletContext().setAttribute("log4j", globallog);
        getServletContext().setAttribute("log4jLocation", log4jLocation);
    }
}
