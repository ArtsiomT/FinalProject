package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.content.RequestContent;
import by.epam.terehovich.internetprovider.entity.User;
import by.epam.terehovich.internetprovider.logic.RegistrationLogic;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;
import by.epam.terehovich.internetprovider.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.GregorianCalendar;

/**
 * Created by aterehovich on 20.7.15.
 */
public class RegistrationCommand implements ActionCommand {
    @Override
    public String execute(RequestContent request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        User user = buildUser(request);
        if(RegistrationLogic.checkRegistration(user)){
            return page;
        } else {
            page = ConfigurationManager.getProperty("path.page.registration");
            request.setAttribute("errorMessage", MessageManager.getProperty("message.registration.loginexist")) ;
        }
        return page;
    }

    private User buildUser(RequestContent request){
        int id = 0;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int role = 1;
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String secondname = request.getParameter("secondname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));
        GregorianCalendar birth = new GregorianCalendar(year, month, day);

        return new User(id, login, password, email, role, firstname, secondname, lastname,
                address, city, birth);
    }
}
