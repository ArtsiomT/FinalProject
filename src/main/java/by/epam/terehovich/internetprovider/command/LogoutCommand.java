package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by aterehovich on 18.7.15.
 */
public class LogoutCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        request.getSession().invalidate();
        return page;
    }
}
