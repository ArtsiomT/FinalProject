package by.epam.terehovich.internetprovider.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by aterehovich on 20.7.15.
 */
public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAtributes;

    public SessionRequestContent(HttpServletRequest request){
        requestAttributes = new LinkedHashMap<>();
        requestParameters = new LinkedHashMap<>();
        sessionAtributes = new LinkedHashMap<>();
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attrName = attributeNames.nextElement();
            Object attrValue = request.getAttribute(attrName);
            requestAttributes.put(attrName, attrValue);
        }

        requestParameters.putAll(request.getParameterMap());
        HttpSession session = request.getSession();
        Enumeration<String> sessionAttrNames = request.getAttributeNames();
        while (sessionAttrNames.hasMoreElements()){
            String attrName = sessionAttrNames.nextElement();
            Object attrValue = session.getAttribute(attrName);
            sessionAtributes.put(attrName, attrValue);
        }

    }

    public Object getRequestAttribute(String key) {
        return requestAttributes.get(key);
    }

    public Object setRequestAttribute(String key, Object value) {
        return requestAttributes.put(key, value);
    }

    public String getRequestParameter(String key) {
        return requestParameters.get(key)[0];
    }

    public Object getSessionAttribute(String key){
        return sessionAtributes.get(key);
    }

    public Object setSessionAttribute(String key, Object value){
        return sessionAtributes.put(key, value);
    }
}
