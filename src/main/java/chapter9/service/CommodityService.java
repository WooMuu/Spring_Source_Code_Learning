package chapter9.service;

import chapter9.pojo.Commodity;

/**
 * Created by zjb on 2019/11/20.
 */
public interface CommodityService {

    void insertCommodity(Commodity commodity);

    Commodity getCommodity(int id);

    Commodity getCommodityByName(String name);

    public void addUser();
}
