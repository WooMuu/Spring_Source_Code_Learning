package chapter7.aop_demo;

import org.springframework.aop.framework.AopContext;

/**
 * Created by zjb on 2019/10/29.
 */
public class TestBean {
    private String str = "msg";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void test() {
        System.out.println(str);
        ((TestBean) (AopContext.currentProxy())).test1();
    }

    public void test1() {
        System.out.println("test1:" + str);
    }

    private String data = "w";

}
