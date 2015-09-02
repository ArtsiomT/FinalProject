package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.content.RequestContent;
import by.epam.terehovich.internetprovider.entity.User;
import by.epam.terehovich.internetprovider.logic.CabinetLogic;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;

/**
 * Created by aterehovich on 22.7.15.
 */
public class CabinetCommand implements ActionCommand {
    @Override
    public String execute(RequestContent request) {
        String page = ConfigurationManager.getProperty("path.page.cabinet");

        String user = (String) request.getSessionAttribute("user");
        if(user!=null) {
            User currentUser = CabinetLogic.getUser(user);
            switch(currentUser.getRole()){
                case 1:
                    page = ConfigurationManager.getProperty("path.page.cabinet");
                    break;
                case 2:
                    page = ConfigurationManager.getProperty("path.page.admin-cabinet");
                    break;
                case 3:
                    page = ConfigurationManager.getProperty("path.page.connect-cabinet");
                    break;
                default:
                    break;
            }
            request.setSessionAttribute("account", CabinetLogic.getUser(user));
        } else{
            request.setAttribute("wrongaction", "message.wrongaction");
            page = ConfigurationManager.getProperty("path.page.index");
        }

        return page;
    }
}
