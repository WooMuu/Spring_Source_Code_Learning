package chapter11.myServletcontextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by zjb on 2019/11/8.
 */
public class MyServletContextListener implements ServletContextListener {

    private ServletContext servletContext = null;

    //该方法在servletContext启动之后被调用，并准备好处理请求
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();

        //实现在自己的逻辑，并将结果记录在ServletContext中
        this.servletContext.setAttribute("MyData", "this is myData");
    }

    //这个方法在servletcontext将要被关闭时调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.servletContext = null;
    }
}
