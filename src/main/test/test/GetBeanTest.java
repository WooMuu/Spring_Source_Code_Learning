package test;

import com.opensymphony.xwork2.Action;
import org.springframework.context.annotation.*;
import org.springframework.util.StopWatch;

public class GetBeanTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
        // warming
        for (int i = 0; i < 1000; i++)
            ctx.getBean("action");
        int iterations = 1000000;
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < iterations; i++)
            ctx.getBean("action");
        sw.stop();
        System.out.println(sw.getLastTaskTimeMillis());
        ctx.close();

    }
    @Configuration
    @ComponentScan
    static class MyConfiguration {
        @Bean
        @Scope("prototype")
        public Action action() {
            return new Action() {
                @Override
                public String execute() throws Exception {
                    return null;
                }
            };
        }
    }
}