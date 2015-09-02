package by.epam.terehovich.internetprovider.command.factory;

import by.epam.terehovich.internetprovider.command.ActionCommand;
import by.epam.terehovich.internetprovider.command.EmptyCommand;
import by.epam.terehovich.internetprovider.command.client.CommandEnum;
import by.epam.terehovich.internetprovider.content.RequestContent;
import by.epam.terehovich.internetprovider.resource.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by aterehovich on 18.7.15.
 */
public class ActionFactory {
    private static final Logger LOGGER = Logger.getLogger(ActionFactory.class);
    public ActionCommand defineCommand(RequestContent request){
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        LOGGER.info(action);
        if(action == null || action.isEmpty()){
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e){
            request.setAttribute("wrong action", action + MessageManager.getProperty("message.wrongaction"));
        }

        return current;
    }
}
