package by.epam.terehovich.internetprovider.logic;

import by.epam.terehovich.internetprovider.dao.UserDAO;
import by.epam.terehovich.internetprovider.entity.User;

/**
 * Created by aterehovich on 18.7.15.
 */
public class LoginLogic {

    public static boolean checkLogin(String enterLogin, String enterPassword){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findByKey(enterLogin);
        if (user!= null){
            return (user.getPassword().equals(enterPassword));
        } else {
            return false;
        }
    }
}
