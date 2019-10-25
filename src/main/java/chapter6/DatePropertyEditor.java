package chapter6;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zjb on 2019/10/24.
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    private String format = "yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text:" + text);
        SimpleDateFormat format = new SimpleDateFormat(this.format);
        try {
            Date date = format.parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
