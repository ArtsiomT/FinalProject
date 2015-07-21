package by.epam.terehovich.internetprovider.logic;

import by.epam.terehovich.internetprovider.dao.UserDAO;
import by.epam.terehovich.internetprovider.entity.User;

/**
 * Created by aterehovich on 20.7.15.
 */
public class RegistrationLogic {

    private static String errorMessage;

    public static boolean checkRegistration(User user){
        boolean result = false;
        UserDAO userDAO = new UserDAO();
        User getUser = userDAO.findByLogin(user.getLogin());
        if (getUser == null){
            userDAO = new UserDAO();
            System.out.println("Adding new user");
            return userDAO.insertNew(user);
        } else {
            System.out.println("Login exist");
            return result;
        }
    }
}
