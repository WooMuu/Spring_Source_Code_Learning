package chapter11.myservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zjb on 2019/11/11.
 */
public class MyHttpServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("myServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogic(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogic(req, resp);
    }

    private void handleLogic(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("handle myLogic");
        ServletContext servletContext = getServletContext();
        RequestDispatcher rd = null;
        rd = servletContext.getRequestDispatcher("/WEB-INF/index.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
