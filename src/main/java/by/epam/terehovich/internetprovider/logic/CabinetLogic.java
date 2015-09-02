package by.epam.terehovich.internetprovider.logic;

import by.epam.terehovich.internetprovider.dao.UserDAO;
import by.epam.terehovich.internetprovider.entity.User;

/**
 * Created by aterehovich on 22.7.15.
 */
public class CabinetLogic {
    public static User getUser(String login){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findByKey(login);
        return user;
    }
}
