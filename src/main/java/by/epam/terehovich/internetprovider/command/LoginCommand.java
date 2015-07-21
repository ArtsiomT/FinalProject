package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.logic.LoginLogic;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;
import by.epam.terehovich.internetprovider.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by aterehovich on 18.7.15.
 */
public class LoginCommand implements ActionCommand{
    private final static String PARAM_NAME_LOGIN = "login";
    private final static String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);

        if (LoginLogic.checkLogin(login, password)){
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.index");
            session.setAttribute("user", login);
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
