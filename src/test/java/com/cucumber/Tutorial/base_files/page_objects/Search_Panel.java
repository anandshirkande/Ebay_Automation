package com.cucumber.Tutorial.base_files.page_objects;

import com.cucumber.Tutorial.base_files.framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by shirkandea on 14/04/2017.
 */
public class Search_Panel extends ParentPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='gh-ac']")
    WebElement input_Search;


    @FindBy(xpath = "//input[@id='gh-btn' and @value='Search']")
    WebElement button_Search;

    public Search_Panel(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void Search_Item(String strItem){
        verify_Element_displayed(input_Search);
        typeText(input_Search, strItem);
        verify_Element_displayed(button_Search);
        Click(button_Search);
    }

}
