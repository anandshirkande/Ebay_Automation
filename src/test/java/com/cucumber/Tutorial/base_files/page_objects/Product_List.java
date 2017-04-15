package com.cucumber.Tutorial.base_files.page_objects;

import com.cucumber.Tutorial.base_files.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shirkandea on 15/04/2017.
 */
public class Product_List extends ParentPage {

    private WebDriver driver;
    String tempTitle;
    String temp;
    Double  tempPrice;

    By Search_Result_Product = By.xpath("//div[@id='ResultSetItems']//li[contains(@class,'sresult')]");


    public Product_List(WebDriver driver){

        super(driver);
        this.driver = driver;
    }

    public ArrayList<Product_Item> Sort_Product_List(ArrayList<Product_Item> list_temp_Product,String strCriterion, String strOrder){

       switch (strCriterion.toLowerCase()){

           case "title":

               if (strOrder.equalsIgnoreCase("ascending")){

               }else if(strOrder.equalsIgnoreCase("descending")){

               }
               break;

           case "price":

               if (strOrder.equalsIgnoreCase("ascending")){

                   Collections.sort(list_temp_Product, Product_Item.proPrice_Ascending);

               }else if(strOrder.equalsIgnoreCase("descending")){

                   Collections.sort(list_temp_Product, Product_Item.proPrice_Descending);
               }
               break;

           default:
       }

        return  list_temp_Product;
    }


    public ArrayList<Product_Item> Fetch_Product_List(){

        ArrayList<Product_Item> list_Product = new ArrayList<Product_Item>();

        List<WebElement> list_Search_Result = driver.findElements(Search_Result_Product);

        for (int i=0; i<list_Search_Result.size(); i++){

            tempTitle = list_Search_Result.get(i).findElement(By.xpath("//h3[contains(@class,'lvtitle')]/a[contains(@class,'vip')]")).getText();
            temp = list_Search_Result.get(i).findElement(By.xpath("//li[contains(@class, 'lvprice')]/span[@class='bold']")).getText();
            temp = temp.replace("£", "");
            temp = temp.replace(",", "");
            tempPrice = Double.valueOf(temp);

            list_Product.add(new Product_Item(driver,tempTitle, tempPrice));

        }

        return  list_Product;
    }

    public void Verify_Product_List_Title(String strCriterion){

        ArrayList<Product_Item> list_Product = Fetch_Product_List();

        String tempTitle;
        String tempLog;

        boolean result = true;

        for(Product_Item temp : list_Product){

            tempTitle = temp.getProductTitle();

            tempLog = "Product title does not contain expected search criterion. Actual product title is "+tempTitle+" and expected criterion was "+strCriterion;

            Assert.assertEquals(true,tempTitle.toLowerCase().contains(strCriterion.toLowerCase()), tempLog);
        }
    }

    public void Verify_Sorting_Order(String strSortCriterion){

        ArrayList<Product_Item> tempDisplayedList = Fetch_Product_List();
        ArrayList<Product_Item> expectedList;

        switch (strSortCriterion.toLowerCase()){

            case "highest price":
                expectedList = Sort_Product_List(tempDisplayedList,"price", "descending");
                break;

            case "lowest price":
                expectedList = Sort_Product_List(tempDisplayedList,"price", "ascending");
                break;

            default:
                expectedList = Sort_Product_List(tempDisplayedList,"price", "ascending");

        }

        compare_ArrayList(tempDisplayedList, expectedList);
    }



    public void compare_ArrayList(ArrayList<Product_Item> arrActual, ArrayList<Product_Item> arrExpected){

        boolean result = true;

        if (arrActual.isEmpty()|| arrExpected.isEmpty() ){

           Assert.assertEquals(true, false, "Both or any one arraylist is empty");
        }

        for (int i=0; i<arrActual.size(); i++ ){

            if (!arrActual.get(i).equals(arrExpected.get(i))){

                result = false;
                break;
            }
        }

      Assert.assertEquals(true, result, "Both array list are matching.");

    }
}
