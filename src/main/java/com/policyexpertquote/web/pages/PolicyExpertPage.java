package com.policyexpertquote.web.pages;

import com.policyexpertquote.web.base.BasePage;
import com.policyexpertquote.web.data.UserData;
import com.policyexpertquote.web.helper.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;

import static java.util.Calendar.*;
import static java.util.Calendar.YEAR;


public class PolicyExpertPage extends BasePage{


    @FindBy(xpath = "(//span[@class='crumb-stage-text hidden-xs hidden-sm'])[1]")
    WebElement headingXLarge;

    @FindBy(xpath = "//div[text()='About you']")
    WebElement Aboutyou;

    //@FindBy(xpath = "//select[@class='form-control'][@data-di-id='di-id-f0e5ef83-5894a860']")
    @FindBy(xpath = "//div[@class='form-group question-select   ']//div[@class='row question-row-title']//div[@class='questionset-input']//select")
    WebElement salutationElement;


    //
    @FindBy(xpath = "//div[@class='form-group question-text   ']//div[@class='row question-row-first-name']//div[@class='questionset-input']//input")
    WebElement firstNameElement;

    @FindBy(xpath = "//div[@class='row question-row-last-name']//div[@class='questionset-input']//input")
    WebElement lastNameElement;


    //div[@class='row question-row-what-is-your-date-of']//div[@class='questionset-input']
    @FindBy(xpath = "//div[@class='row question-row-what-is-your-date-of']//*//option[text()='Day']/parent::select")
    WebElement dateDOBElement;

    //div[@class='row question-row-what-is-your-date-of']//*//option[text()='Month']//parent::select
    @FindBy(xpath = "(//div[@class='row question-row-what-is-your-date-of']//*//select)[2]")
    WebElement monthDOBElement;

    @FindBy(xpath = "(//div[@class='row question-row-what-is-your-date-of']//*//select)[3]")
    WebElement yearDOBElement;

    @FindBy(xpath = "//div[@class='row question-row-what-is-your-marital']//*//option[text()='Married']/parent::select")
    WebElement martialStatusElement;

    @FindBy(xpath = "//div[@class='row question-row-main-phone-number']//*//input")
    WebElement mobilenoElement;

    @FindBy(xpath = "//div[@class='row question-row-what-is-your-occupat']//*//input")
    WebElement occupationElement;

    @FindBy(xpath = "//li[@class='list-group-item ']")
    WebElement occupationElementSelect;


    @FindBy(xpath = "//div[@class='row question-row-do-you-have-another']//*//button[text()='No']")
    WebElement noForOtherOccupationElement;

    @FindBy(xpath = "//div[@class='row question-row-do-you-have-another']//*//button[@type='button' and text()='Yes']")
    WebElement yesForOtherOccupationElement;


    @FindBy(xpath = "//div[@class='row question-row-what-is-your-e-mail']//*//input")
    WebElement emailElement;



    //div[@class='row question-row-do-you-have-another']//*//button[@type='button' and contains(., 'No')]


    protected final String startPageTitle = "Details";
    protected final String homePageHeading = "About you";

    public PolicyExpertPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openStartPage() {
        goToWeb(PropertiesProvider.getProperties().getProperty("starturl"));
        waitUntilUrlContains(PropertiesProvider.getProperties().getProperty("starturl"));
    }

    public void verifyHomePage() {
        waitUntilUrlContains("home");
        checkIfTextIsExpected(Aboutyou, homePageHeading);
    }

    public void checkStartPage() {
        waitUntilUrlContains("home");
        checkIfTextIsExpected(headingXLarge, startPageTitle);
        checkIfPageTitleContains(startPageTitle);
    }

    public void selectSalutation(String salutation) {
        waitUntilUrlContains("home");
        selectByVisibleTextInDropDown(salutationElement,salutation);

    }

    public void fillAboutYou(UserData user) {
        waitUntilUrlContains("home");
        selectByVisibleTextInDropDown(salutationElement,user.getSalutation());
        //clickOn(firstNameElement);
        waitUntilElement(firstNameElement);
        inputTextBox(firstNameElement,user.getFirstname());
        //clickOn(lastNameElement);
        waitUntilElement(lastNameElement);

        inputTextBox(lastNameElement,user.getLastname());
        int year = user.getDob().get(YEAR) ;
        int month = user.getDob().get(MONTH) + 1;
        int day = user.getDob().get(DATE);

        waitUntilElement(monthDOBElement);
        System.out.println("month " + month);
        selectByValueTextInDropDown(monthDOBElement,String.valueOf(month));
        waitUntilElement(dateDOBElement);
        selectByVisibleTextInDropDown(dateDOBElement,String.valueOf(day));
        waitUntilElement(yearDOBElement);
        selectByVisibleTextInDropDown(yearDOBElement,String.valueOf(year));
        //clickOn(martialStatusElement);
        waitUntilElement(martialStatusElement);
        selectByVisibleTextInDropDown(martialStatusElement,user.getMartialstatus());
        //clickOn(mobilenoElement);
        waitUntilElement(mobilenoElement);
        inputTextBox(mobilenoElement,user.getMobileno());
        //clickOn(occupationElement);
        waitUntilElement(occupationElement);
        clickOn(occupationElementSelect);
        inputTextBox(occupationElement,user.getOccupation());
        if(user.getOtheroccupation() == "Yes" ) {
            clickOn(yesForOtherOccupationElement);
        }else{
            clickOn(noForOtherOccupationElement);

        }
        //clickOn(emailElement);
        waitUntilElement(emailElement);
        inputTextBox(emailElement,user.getEmail());



    }
}
