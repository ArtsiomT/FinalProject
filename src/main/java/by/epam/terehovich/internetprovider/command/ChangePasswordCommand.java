package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.content.RequestContent;
import by.epam.terehovich.internetprovider.logic.ChangePasswordLogic;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;

/**
 * Created by aterehovich on 9/3/15.
 */
public class ChangePasswordCommand implements ActionCommand {

    private String result = "";

    @Override
    public String execute(RequestContent request) {
        String page = ConfigurationManager.getProperty("path.page.cabinet");
        String user = (String)request.getSessionAttribute("user");
        String oldPassword = (String)request.getParameter("oldpass");
        String newPassword = (String)request.getParameter("newpass");
        String newPassword2 = (String)request.getParameter("newpass2");
        result = ChangePasswordLogic.changePass(user, oldPassword, newPassword, newPassword2);
        request.setAttribute("result", result);
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                result = "";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return page;
    }
}
