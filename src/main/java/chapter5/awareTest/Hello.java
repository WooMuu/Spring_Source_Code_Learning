package chapter5.awareTest;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by zjb on 2019/10/22.
 */
public class Hello implements InitializingBean {
    public void say() {
        System.out.println("hello");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet executed...");
    }

    public void initMethod() {
        System.out.println("initMethod executed...");
    }
}
