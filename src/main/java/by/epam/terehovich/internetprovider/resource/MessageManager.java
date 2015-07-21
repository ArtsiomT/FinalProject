package by.epam.terehovich.internetprovider.resource;

import java.util.ResourceBundle;

/**
 * Created by aterehovich on 18.7.15.
 */
public class MessageManager {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("localization");

    private MessageManager(){}

    public static String getProperty(String key){
        return RESOURCE_BUNDLE.getString(key);
    }
}
