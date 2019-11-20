package chapter9;

import chapter9.mapper.CommodityMapper;
import chapter9.mybatisOnly.MyatisUtil;
import chapter9.pojo.Commodity;
import chapter9.service.CommodityService;
import chapter9.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * Created by zjb on 2019/11/4.
 */
public class TestChaper9 {
    @Test
    public void testMyBatis() {
        //获取sqlsession
        SqlSession sqlSession = MyatisUtil.getSqlSessionFactory().openSession();
        //测试新增
        try {
            CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);
            Commodity cup = new Commodity("cup", new BigDecimal(12));
            commodityMapper.insertCommodity(cup);
            sqlSession.commit();//这里一定要提交，不然数据无法进入数据库

            //测试查询
            Commodity commodity = commodityMapper.getCommodity(1);
            System.out.println(commodity);
        } finally {
            sqlSession.close();
        }
    }

    private ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("classpath:chapter9/configuration/spring.xml");
    }

    @Test
    public void testAddCommodity() {
        CommodityService service = (CommodityService) context.getBean("commodityService");
        service.insertCommodity(new Commodity("aop", new BigDecimal(2222)));

    }

    @Test
    public void testGetCommodityByName() {
        CommodityService service = (CommodityService) context.getBean("commodityService");
        Commodity existDisk = service.getCommodityByName("aop");
        System.out.println(existDisk);
    }

    @Test
    public void testGetUserByName() {
        UserService service = (UserService) context.getBean("userService");
        System.out.println(service.getUserByName("aop"));
    }
}
