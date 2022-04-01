package com.policyexpertquote.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.policyexpertquote.web.data.UserData;
import com.policyexpertquote.web.helper.DriverProvider;
import com.policyexpertquote.web.pages.PolicyExpertPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.java.DataTableType;

public class StepDefinitions {

    private final PolicyExpertPage policyExpertPage;

    //Constructor
    public StepDefinitions(){
        policyExpertPage = new PolicyExpertPage(DriverProvider.getDriver());
    }

    @Given("User is on policy expert quote tool page")
    public void user_is_on_policy_expert_quote_tool_page() {
        policyExpertPage.openStartPage();
    }

    @When("User is on home page")
    public void user_is_on_home_page() {
        policyExpertPage.verifyHomePage();
    }

    @Then("I should be able to view Go to compare page")
    public void i_should_be_able_to_view_Go_to_compare_page() {
        policyExpertPage.checkStartPage();
    }

    @And("user selects title as {string}")
    public void user_selects_title_as(String salutation) {
        policyExpertPage.selectSalutation(salutation);
    }


    @And("user enters")
    public void policy_table_with_example(DataTable dataTable) {
        List<UserData> policyUserList = new ArrayList<>();
        List<Map<String,String>> mapList = dataTable.transpose().asMaps();
        for(Map<String, String> map : mapList) {
            policyUserList.add(new ObjectMapper().convertValue(map, UserData.class));
        }
        policyUserList.forEach(user -> {

            System.out.println(user);
            policyExpertPage.fillAboutYou(user);
        });



    }

}