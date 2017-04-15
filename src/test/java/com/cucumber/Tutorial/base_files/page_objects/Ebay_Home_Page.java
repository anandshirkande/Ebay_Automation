package com.cucumber.Tutorial.base_files.page_objects;

import com.cucumber.Tutorial.base_files.framework.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;

/**
 * Created by shirkandea on 14/04/2017.
 */
public class Ebay_Home_Page extends ParentPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='gh-la' and text()='eBay']/img[@id='gh-logo']")
    WebElement logo_Ebay;


    private Search_Panel objSearch;
    private Sort_Panel objSort;
    private Product_List obj_Product_List;

    public Ebay_Home_Page(WebDriver driver){
        super(driver);
        this.driver = driver;
        objSearch = new Search_Panel(driver);
        obj_Product_List = new Product_List(driver);
        objSort = new Sort_Panel(driver);
        PageFactory.initElements(driver, this);
    }

    public void Verify_Ebay_Home_Page(){

        verify_Element_displayed(logo_Ebay);
        Assert.assertEquals(true, driver.getTitle().toLowerCase().contains("ebay"), "Ebay Home Page Title does not contains word 'EBAY'");
    }

    public void Search_Item(String strItem){
        objSearch.Search_Item(strItem);
    }

    public void Verify_Search_Result(String strItem){

        obj_Product_List.Verify_Product_List_Title(strItem);
    }

    public void Sort_Search_Result(String strSortCriterion){
        objSort.Sort_Product_List(strSortCriterion);
    }

    public void Verify_Search_Result_Sorting_Order(String strSortCriterion){
        obj_Product_List.Verify_Sorting_Order(strSortCriterion);

    }

}
