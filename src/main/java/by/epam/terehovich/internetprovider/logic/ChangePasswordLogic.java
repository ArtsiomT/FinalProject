package by.epam.terehovich.internetprovider.logic;

import by.epam.terehovich.internetprovider.dao.UserDAO;
import by.epam.terehovich.internetprovider.entity.User;
import by.epam.terehovich.internetprovider.resource.MessageManager;

/**
 * Created by aterehovich on 9/3/15.
 */
public class ChangePasswordLogic {

    private static String result;

    public static String changePass(String user, String oldPassword, String newPassword, String newPassword2){
        UserDAO userDAO = new UserDAO();
        User currUser = userDAO.findByKey(user);
        userDAO = new UserDAO();
        if(currUser != null){
            if (checkOldPass(currUser, oldPassword) && checkNewPass(newPassword, newPassword2)){
                userDAO.updatePassword(currUser.getId(), newPassword);
                result = MessageManager.getProperty("page.cabinet.message.success");
            }
        }
        return result;
    }

    private static boolean checkOldPass(User user, String oldPassword){
        if (user.getPassword().equals(oldPassword)){
            return true;
        } else {
            result = MessageManager.getProperty("page.cabinet.message.incorrect-old-password");
            return false;
        }
    }

    private static boolean checkNewPass(String newPassword, String newPassword2){
        if(newPassword.equals(newPassword2)){
            return true;
        } else {
            result = MessageManager.getProperty("page.cabinet.message.incorrect-new-password");
            return false;
        }
    }
}
