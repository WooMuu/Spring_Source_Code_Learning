package chapter11.controller;

import chapter11.model.Cellphone;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by zjb on 2019/11/7.
 */
public class CellphoneController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArrayList<Cellphone> cellphoneList = new ArrayList<>();
        Cellphone huawei = new Cellphone("华为", "2000");
        Cellphone xiaomi = new Cellphone("小米", "1999");
        cellphoneList.add(huawei);
        cellphoneList.add(xiaomi);

        return new ModelAndView("cellphoneList", "cellphones", cellphoneList);
    }
}
