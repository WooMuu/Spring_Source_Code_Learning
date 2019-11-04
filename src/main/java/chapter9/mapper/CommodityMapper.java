package chapter9.mapper;


import chapter9.pojo.Commodity;

/**
 * Created by zjb on 2019/11/3.
 */
public interface CommodityMapper {

    void insertCommodity(Commodity commodity);

    Commodity getCommodity(int id);

    Commodity getCommodityByName(String name);
}
