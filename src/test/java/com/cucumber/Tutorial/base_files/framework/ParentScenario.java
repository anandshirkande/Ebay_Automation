package com.cucumber.Tutorial.base_files.framework;

import com.cucumber.Tutorial.base_files.page_objects.Ebay_Home_Page;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shirkandea on 29/03/2017.
 */
public class ParentScenario {


  private WebDriver driver;
  protected static Ebay_Home_Page obj_Home_Page;
  protected Properties configProp = new Properties();
  protected InputStream in = this.getClass().getClassLoader().getResourceAsStream("data_set.properties");


  public void Before_Setup(){

    driver = new ChromeDriver();

    obj_Home_Page= new Ebay_Home_Page(driver);
  }

  public void After_Setup(){
    driver.quit();
    obj_Home_Page=null;
  }

  public void Launch_URL(String URL){

    driver.get(URL);
  }

  public void Verify_Browser_Launched(){

    String result = driver.toString();
    Assert.assertFalse("Browser not launched", result.isEmpty());
  }


}
