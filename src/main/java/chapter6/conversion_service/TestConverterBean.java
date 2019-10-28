package chapter6.conversion_service;

import java.util.Date;

/**
 * Created by zjb on 2019/10/28.
 */
public class TestConverterBean {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestConverterBean{" +
                "date=" + date +
                '}';
    }
}
