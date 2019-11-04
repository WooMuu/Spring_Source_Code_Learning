package chapter9.pojo;

import java.math.BigDecimal;

/**
 * Created by zjb on 2019/11/3.
 * 商品pojo
 */
public class Commodity {
    private int id;
    private String name;
    private BigDecimal price;
    private String pic;//图片地址

    public Commodity(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    //必须要有个无参构造，不然根据CommodityMapper.xml中的配置，在查询数据库时，将不能反射构造出User实例
    public Commodity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                '}';
    }
}
