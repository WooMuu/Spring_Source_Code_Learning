package chapter7.aop_demo;

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
    }
}
