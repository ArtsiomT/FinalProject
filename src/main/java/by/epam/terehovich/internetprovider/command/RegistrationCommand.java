package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.entity.User;
import by.epam.terehovich.internetprovider.logic.RegistrationLogic;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;
import by.epam.terehovich.internetprovider.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by aterehovich on 20.7.15.
 */
public class RegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.login");
        User user = buildUser(request);
        if(RegistrationLogic.checkRegistration(user)){
            return page;
        } else {
            page = ConfigurationManager.getProperty("path.page.registration");
            request.setAttribute("errorMessage", MessageManager.getProperty("message.registration.loginexist")) ;
        }
        return page;
    }

    private User buildUser(HttpServletRequest request){
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
        GregorianCalendar birth = new GregorianCalendar(2015, 6, 22);

        return new User(id, login, password, email, role, firstname, secondname, lastname,
                address, city, birth);
    }
}
