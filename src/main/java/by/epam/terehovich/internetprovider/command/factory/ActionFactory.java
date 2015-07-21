package by.epam.terehovich.internetprovider.command.factory;

import by.epam.terehovich.internetprovider.command.ActionCommand;
import by.epam.terehovich.internetprovider.command.EmptyCommand;
import by.epam.terehovich.internetprovider.command.client.CommandEnum;
import by.epam.terehovich.internetprovider.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by aterehovich on 18.7.15.
 */
public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request){
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
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
