package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.content.RequestContent;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;

/**
 * Created by aterehovich on 18.7.15.
 */
public class LogoutCommand implements ActionCommand{
    @Override
    public String execute(RequestContent request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        request.invalidate();
        return page;
    }
}
