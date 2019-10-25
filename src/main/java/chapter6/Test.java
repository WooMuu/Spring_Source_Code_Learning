package chapter6;

import chapter5.awareTest.Hello;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/10/22.
 */
public class Test {
    //配置文件路径可以设置成一个正则表达式的格式
    private static final String[] configLocations = {"${chapter6}/test.xml"};

    @Before
    public void before() {
        System.getProperties().setProperty("chapter6", "chapter6");
        System.getProperties().setProperty("VAR", "VAR");
    }

    @org.junit.Test
    public void test() {
        String[] configLocations = {"${chapter6}/test.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocations, true);
        context.getBean("hello");
    }

    @org.junit.Test
    public void testMyClasspathXmlApplicationContext() {
        MyClassPathXmlApplicationContext context = new MyClassPathXmlApplicationContext(configLocations);

        context.getBean("hello");
    }

    @org.junit.Test
    public void testRefresh() {
        MyClassPathXmlApplicationContext context = new MyClassPathXmlApplicationContext(configLocations);
        Hello hello1 = (Hello) context.getBean("hello");
        hello1.setMessage("refresh1");
        hello1.say();
        context.refresh();
        Hello hello2 = (Hello) context.getBean("hello");
        hello2.say();
    }

    //使用自定义属性编辑器
    @org.junit.Test
    public void testPropertyEditor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter6/testPropertyEditor.xml");
        Object userManager = context.getBean("userManager");
        System.out.println(userManager.toString());
    }

    //注册spring自带的属性编辑器CustomeDateEditor
    @org.junit.Test
    public void testDatePropertyEditorRegsitar() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter6/DatePropertyEditorRegistarTest.xml");
        UserManager userManager = (UserManager) context.getBean("userManager");
        System.out.println(userManager.toString());
    }
}
