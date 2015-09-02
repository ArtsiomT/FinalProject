package by.epam.terehovich.internetprovider.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by aterehovich on 21.7.15.
 */
public class DateChooseTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        try {
            writer.write("<select name=\"year\" id=\"date\">");
            for (int i = 1900; i<=calendar.get(Calendar.YEAR); i++){
                if(i==calendar.get(Calendar.YEAR)){
                    writer.write("<option value=\""+i+"\" selected>"+i+"</option>");
                } else {
                    writer.write("<option value=\""+i+"\">"+i+"</option>");
                }
            }
            writer.write("</select>");
            writer.write("<select name=\"month\">");
            for (int i = 1; i<=12; i++){
                if(i==calendar.get(Calendar.MONTH)+1){
                    writer.write("<option value=\""+i+"\" selected>"+i+"</option>");
                } else {
                    writer.write("<option value=\""+i+"\">"+i+"</option>");
                }
            }
            writer.write("</select>");
            writer.write("<select name=\"day\">");
            for (int i = 1; i<=31; i++){
                if(i==calendar.get(Calendar.DAY_OF_MONTH)){
                    writer.write("<option value=\""+i+"\" selected>"+i+"</option>");
                } else {
                    writer.write("<option value=\""+i+"\">"+i+"</option>");
                }
            }
            writer.write("</select>");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.SKIP_BODY;
    }
}
