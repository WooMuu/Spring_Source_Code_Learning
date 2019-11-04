package chapter9;

import chapter9.mybatisOnly.MyatisUtil;
import chapter9.mapper.CommodityMapper;
import chapter9.pojo.Commodity;
import org.apache.ibatis.session.SqlSession;
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

    @Test
    public void testMybatisSpring() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter9/configuration/spring.xml");
        CommodityMapper commodityMapper = (CommodityMapper) context.getBean("commodityMapper");
        Commodity commodity = commodityMapper.getCommodity(1);
        System.out.println(commodity);
//        Commodity computer = new Commodity("computer", new BigDecimal(9999));
//        commodityMapper.insertCommodity(computer);
        Commodity computer = commodityMapper.getCommodityByName("computer");
        System.out.println(computer);


    }
}
