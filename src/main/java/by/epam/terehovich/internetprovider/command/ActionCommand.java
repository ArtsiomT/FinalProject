package by.epam.terehovich.internetprovider.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by aterehovich on 18.7.15.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
