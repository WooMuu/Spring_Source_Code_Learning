package chapter6;

import chapter5.awareTest.Hello;
import chapter6.application_event_multicaster.TestEvent;
import chapter6.bean_factory_post_processor.HelloMessage;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

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

    //注册spring自带placeholder的beanFactoryPostProcessor,通过这个对象，可以用${placeholder} 的方式将注入的属性值抽取到一个或多个文件中统一管理
    @org.junit.Test
    public void testBeanFactoryPostProcessor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter6/test_beanFactoryPostProcessor.xml");
        HelloMessage helloMS = (HelloMessage) context.getBean("helloMS");
        System.out.println(helloMS.getMessage());
    }

    //注册自定义的beanfactoryProcessor
    public void testMyBeanFactoryProcessor() {

    }

    //Locale类获取默认的本地Locale
    @org.junit.Test
    public void testLocale() {
        System.out.println(Locale.getDefault());
    }

    @org.junit.Test
    public void testMessageFormat() {
        String pattern1 = " {0} ,你好！你于 {1} 在工商银行存入 {2} 元。";
        String pattern2 = "At {1,time,short} On {1,date,long} {0} paid {2,number,currency}.";
        //用于动态替换占位符的参数
        Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};

        //使用默认本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1, params);
        System.out.println("msg1:" + msg1);

        //使用制定的本地化对象格式化信息
        MessageFormat messageFormat = new MessageFormat(pattern2, Locale.US);
        String msg2 = messageFormat.format(pattern2, params);
        System.out.println("msg2:" + msg2);
    }

    @org.junit.Test
    public void testMessagesBundles() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter6/messages.xml");
        //直接通过容器访问国际化信息
        Object[] params = {"John ", new GregorianCalendar().getTime()};
        String str1 = context.getMessage("test", params, Locale.US);
        String str2 = context.getMessage("test", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }

    //测试自定义的applicationlistener
    @org.junit.Test
    public void testApplicationListener() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter6/listeners.xml");
        TestEvent event = new TestEvent("hello", "msg");
        context.publishEvent(event);
    }

    //测试自定义的converter
    @org.junit.Test
    public void testConverter() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter6/conversion_service.xml");
        Object bean = context.getBean("testConverterBean");
        System.out.println(bean);
    }
}
