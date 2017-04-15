package com.cucumber.Tutorial.base_files.page_objects;

import com.cucumber.Tutorial.base_files.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by shirkandea on 15/04/2017.
 */
public class Sort_Panel extends ParentPage {

    private WebDriver driver;

    By dashboard_Sort = By.id("DashSortByContainer");
    By list_Sort_Option = By.xpath("//div[@id='DashSortByContainer']//ul[contains(@class, 'dropdown-menu')]//a");


    public Sort_Panel(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void Sort_Product_List(String sortCriterion){

        verify_Element_displayed(dashboard_Sort);
        Click(dashboard_Sort);
        List<WebElement> List_Sort_Option = get_Element_List(list_Sort_Option);

        boolean result = false;

        for(WebElement temp:List_Sort_Option){

            if (temp.getText().equalsIgnoreCase(sortCriterion)){
                result = true;
                Click(temp);
                break;
            }
        }
        Assert.assertEquals(true, result,"Sort criterion not found. Expected criterion was "+ sortCriterion );
    }
}
