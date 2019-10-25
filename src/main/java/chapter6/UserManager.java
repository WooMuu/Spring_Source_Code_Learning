package chapter6;

import java.util.Date;

/**
 * Created by zjb on 2019/10/24.
 */
public class UserManager {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "date=" + date +
                '}';
    }
}
