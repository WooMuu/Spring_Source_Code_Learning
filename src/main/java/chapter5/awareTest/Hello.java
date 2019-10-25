package chapter5.awareTest;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by zjb on 2019/10/22.
 */
public class Hello implements InitializingBean {
    private String message;

    public void say() {
        System.out.println(message == null ? "hello" : message);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet executed...");
    }

    public void initMethod() {
        System.out.println("initMethod executed...");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
