package chapter9.service.impl;

import chapter8.pojo.User;
import chapter9.mapper.CommodityMapper;
import chapter9.mapper.UserMapper;
import chapter9.pojo.Commodity;
import chapter9.service.CommodityService;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zjb on 2019/11/20.
 */
@EnableAspectJAutoProxy(exposeProxy = true)
public class CommodityServiceImpl implements CommodityService {
    private CommodityMapper mapper;
    private UserMapper userMapper;

    @Override
    public void insertCommodity(Commodity commodity) {
        mapper.insertCommodity(commodity);
        CommodityService service = (CommodityService) AopContext.currentProxy(); //获取代理对象
        service.addUser();

    }

    @Transactional
    public void addUser() {
        userMapper.insertUser(new User("aopconte", 1, "women"));
        throw new RuntimeException("user 事务抛出异常了");
    }

    @Override
    public Commodity getCommodity(int id) {
        return mapper.getCommodity(id);
    }

    @Override
    public Commodity getCommodityByName(String name) {
        return mapper.getCommodityByName(name);
    }

    public CommodityMapper getMapper() {
        return mapper;
    }

    public void setMapper(CommodityMapper mapper) {
        this.mapper = mapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
