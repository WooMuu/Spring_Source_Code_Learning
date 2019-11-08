package chapter11.model;

/**
 * Created by zjb on 2019/11/7.
 */
public class Cellphone {
    private String brand;
    private String price;

    public Cellphone() {
    }

    public Cellphone(String brand, String price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
