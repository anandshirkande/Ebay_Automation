package com.cucumber.Tutorial.base_files.glue;

import com.cucumber.Tutorial.base_files.framework.ParentScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by shirkandea on 13/04/2017.
 */
public class Search_Sort_Functionality extends ParentScenario {

    @When("I search for \"(.*)\"")
    public void Search_For_Item(String strItem){
       obj_Home_Page.Search_Item(strItem);
    }

    @Then("I can see search results for \"(.*)\"")
    public void Verify_Search_Result(String strItem){
        obj_Home_Page.Verify_Search_Result(strItem);
    }

    @Then("Search result list is sorted on \"(.*)\"")
    public void Verify_Search_Result_Sorting_Order(String strSortCriterion){
        obj_Home_Page.Verify_Search_Result_Sorting_Order(strSortCriterion);
    }

    @And("I sort result list based on \"(.*)\"")
    public void Sort_Search_Result(String strSortCriterion){

        obj_Home_Page.Sort_Search_Result(strSortCriterion);
    }




}
