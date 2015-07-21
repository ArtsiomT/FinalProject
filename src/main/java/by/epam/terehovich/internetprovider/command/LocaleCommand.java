package by.epam.terehovich.internetprovider.command;

import by.epam.terehovich.internetprovider.command.client.LocaleEnum;
import by.epam.terehovich.internetprovider.resource.ConfigurationManager;
import by.epam.terehovich.internetprovider.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by aterehovich on 18.7.15.
 */
public class LocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        String choosedLocale = request.getParameter("locale");
        String locale;
        LocaleEnum localeEnum;
        try {
            localeEnum = LocaleEnum.valueOf(choosedLocale.toUpperCase());
            locale = localeEnum.getLocale();
            request.setAttribute("lang", locale);
            request.getSession().setAttribute("lang", locale);
        } catch (IllegalArgumentException e){
            localeEnum = LocaleEnum.EN;
            locale = localeEnum.getLocale();
            request.getSession().setAttribute("lang", locale);
        }
        return page;
    }
}
