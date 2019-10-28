package chapter6.conversion_service;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zjb on 2019/10/28.
 */
public class String2DateConverter implements Converter<String, Date> {
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String source) {
        Date date = null;
        //测试用，忽略对字符串校验
        try {
            date = new SimpleDateFormat(pattern).parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return date;
        }
    }
}
