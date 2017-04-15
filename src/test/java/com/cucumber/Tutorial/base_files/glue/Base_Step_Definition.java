package com.cucumber.Tutorial.base_files.glue;

import com.cucumber.Tutorial.base_files.framework.ParentScenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shirkandea on 29/03/2017.
 */
public class Base_Step_Definition extends ParentScenario {

    @Before
    public void BeforeScenario(){

        Before_Setup();
    }

    @Given("I have launched browser")
    public void Verify_Browser() {

        Verify_Browser_Launched();
    }

    @Given("I am on ebay home page")
    public void Navigate_To_Ebay() throws  IOException{
        configProp.load(in);
        String URL= configProp.getProperty("Ebay_URL");
        Launch_URL(URL);
        obj_Home_Page.Verify_Ebay_Home_Page();
    }

    @When("I visit to home page")
    public void Verify_HomePage() throws IOException{

        configProp.load(in);
        String URL= configProp.getProperty("Ebay_URL");
        Launch_URL(URL);
    }

    @Then("I should be able to see ebay home page")
    public void Verify_App_Logo(){

        obj_Home_Page.Verify_Ebay_Home_Page();

    }

    @After
    public void After_Scenario(){
        After_Setup();
    }

}
