package by.epam.terehovich.internetprovider.controller;

import by.epam.terehovich.internetprovider.command.ActionCommand;
import by.epam.terehovich.internetprovider.command.factory.ActionFactory;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;
import by.epam.terehovich.internetprovider.resource.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by aterehovich on 15.7.15.
 */
@WebServlet(name = "Controller", urlPatterns = "/control")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controller.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);

        if(page != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullpage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    private void setLocale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter("locale");

        switch (locale){
            case "EN":
                Locale.setDefault(new Locale("en", "EN"));
                request.setAttribute("lang", "en_US");
                LOGGER.info("Locale set to EN");
                break;
            case "RU":
                Locale.setDefault(new Locale("ru", "RU"));
                request.setAttribute("lang", "ru_RU");
                LOGGER.info("Locale set to RU");
                break;
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
