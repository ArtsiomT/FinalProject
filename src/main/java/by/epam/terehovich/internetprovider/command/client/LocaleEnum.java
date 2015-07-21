package by.epam.terehovich.internetprovider.command.client;

import java.util.Locale;

/**
 * Created by aterehovich on 18.7.15.
 */
public enum LocaleEnum {
    RU{
        {
            this.locale = RU_LOCALE;
        }
    },
    EN{
        {
            this.locale = EN_LOCALE;
        }
    };
    private final static String RU_LOCALE = "ru_RU";
    private final static String EN_LOCALE = "en_US";
    String locale;
    public String getLocale(){
        switch (locale){
            case RU_LOCALE:
                Locale.setDefault(new Locale("ru", "RU"));
                break;
            case EN_LOCALE:
                Locale.setDefault(new Locale("en", "US"));
                break;
        }
        return locale;
    }
}
