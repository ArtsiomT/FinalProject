package by.epam.terehovich.internetprovider.controller;

import by.epam.terehovich.internetprovider.command.ActionCommand;
import by.epam.terehovich.internetprovider.command.factory.ActionFactory;
import by.epam.terehovich.internetprovider.content.RequestContent;
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
        String page;
        ActionFactory client = new ActionFactory();
        RequestContent requestContent = new RequestContent(request);
        ActionCommand command = client.defineCommand(requestContent);
        page = command.execute(requestContent);

        if(page != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            requestContent.updateRequest(request);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            requestContent.setSessionAttribute("nullpage", MessageManager.getProperty("message.nullpage"));
            requestContent.updateRequest(request);
            response.sendRedirect(request.getContextPath() + page);
        }
    }


}
