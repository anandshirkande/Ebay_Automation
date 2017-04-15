package com.cucumber.Tutorial.base_files.page_objects;

import com.cucumber.Tutorial.base_files.framework.ParentPage;
import org.openqa.selenium.WebDriver;

import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by shirkandea on 15/04/2017.
 */
public class Product_Item extends  ParentPage{

    private WebDriver driver;
    private String strTitle;
    private Double productPrice;
  //  private Date  strPostedDate;
   // private Date  strEndDate;

    public Product_Item(WebDriver driver, String strTitle, Double productPrice){

        super(driver);
        this.driver = driver;
        this.strTitle = strTitle;
        this.productPrice = productPrice;

    }

    public String getProductTitle(){
        return strTitle;
    }

    public void setProductTitle(String tempTitle){
        strTitle = tempTitle;
    }

    public Double getProductPrice(){
        return productPrice;
    }

    public void setProductPrice(Double productPrice){
        this.productPrice = productPrice;
    }

    public static Comparator<Product_Item> proPrice_Ascending= new Comparator<Product_Item>() {
        @Override
        public int compare(Product_Item o1, Product_Item o2) {

            Double price_one = o1.getProductPrice();
            Double price_two = o2.getProductPrice();

            return price_one.compareTo(price_two);
        }
    };

    public static Comparator<Product_Item> proPrice_Descending= new Comparator<Product_Item>() {
        @Override
        public int compare(Product_Item o1, Product_Item o2) {

            Double price_one = o1.getProductPrice();
            Double price_two = o2.getProductPrice();

            return price_two.compareTo(price_one);
        }
    };

}
