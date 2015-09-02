package by.epam.terehovich.internetprovider.tags;

import by.epam.terehovich.internetprovider.dao.UserDAO;
import by.epam.terehovich.internetprovider.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Artyom on 10.08.2015.
 */
public class UserTableTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        List<User> users = new UserDAO().findAll();
        Iterator<User> iterator = users.iterator();
        try {

            while (iterator.hasNext()){
                User user = iterator.next();
                writer.write("<tr><td>" + user.getId() + "</td><td>"+user.getLogin()+"<td>" + user.getLastname() + " " + user.getFirstname() + " " +
                        user.getSecondname()+"</td><td>" + user.getRole() + "</td><td>" + user.getCity()+"</td><tr>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }
}
