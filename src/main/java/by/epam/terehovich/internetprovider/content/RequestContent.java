package by.epam.terehovich.internetprovider.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by aterehovich on 20.7.15.
 */
public class RequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAtributes;
    private HttpSession session;
    private boolean flag = false;

    public RequestContent(HttpServletRequest request){
        requestAttributes = new LinkedHashMap<>();
        requestParameters = new LinkedHashMap<>();
        sessionAtributes = new LinkedHashMap<>();
        session = request.getSession();
        flag = true;
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attrName = attributeNames.nextElement();
            Object attrValue = request.getAttribute(attrName);
            requestAttributes.put(attrName, attrValue);
        }

        requestParameters.putAll(request.getParameterMap());

        Enumeration<String> sessionAttrNames = session.getAttributeNames();
        while (sessionAttrNames.hasMoreElements()){
            String attrName = sessionAttrNames.nextElement();
            Object attrValue = session.getAttribute(attrName);
            sessionAtributes.put(attrName, attrValue);
        }
    }

    public void updateRequest(HttpServletRequest request){
        String attrName;
        String sessionAttrName;
        Set<String> attrNames = requestAttributes.keySet();
        Iterator<String> iterator = attrNames.iterator();
        while (iterator.hasNext()){
            attrName = iterator.next();
            request.setAttribute(attrName, requestAttributes.get(attrName));
        }
        if(flag) {
            Set<String> sessionAttrNames = sessionAtributes.keySet();
            Iterator<String> sessionIterator = sessionAttrNames.iterator();
            while (sessionIterator.hasNext()) {
                sessionAttrName = sessionIterator.next();
                session.setAttribute(sessionAttrName, sessionAtributes.get(sessionAttrName));
            }
        }
    }

    public Object getAttribute(String key) {
        return requestAttributes.get(key);
    }

    public Object setAttribute(String key, Object value) {
        return requestAttributes.put(key, value);
    }

    public String getParameter(String key) {
        return requestParameters.get(key)[0];
    }

    public Object getSessionAttribute(String key){
        return sessionAtributes.get(key);
    }

    public Object setSessionAttribute(String key, Object value){
        return sessionAtributes.put(key, value);
    }

    public void invalidate() {
        flag = false;
        this.session.invalidate();
    }
}
