package chapter9.mybatisOnly;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by zjb on 2019/11/4.
 */
public class MyatisUtil {
    private final static SqlSessionFactory SQL_SESSION_FACTORY;

    //    通过静态代码块加载mybatis的配置文件，并创建sqlsessionfactory
    static {
        String resource = "chapter9/configuration/mybatis_config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return SQL_SESSION_FACTORY;
    }

}
