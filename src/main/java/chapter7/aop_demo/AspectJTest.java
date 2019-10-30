package chapter7.aop_demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by zjb on 2019/10/29.
 */
@Aspect
public class AspectJTest {
    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    @Pointcut("execution(* *.test1(..))")
    public void test1() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("before test");
    }

    @Before("test1()")
    public void beforeTest1() {
        System.out.println("before test1");
    }

//    @After("test()")
    public void afterTest() {
        System.out.println("after test");
    }

//    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("after1");
        return o;
    }
}
