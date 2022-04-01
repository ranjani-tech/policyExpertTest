package com.policyexpertquote.web;

import com.policyexpertquote.web.helper.DriverProvider;
import com.policyexpertquote.web.helper.PropertiesProvider;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/policyexpertquote/web")

@ConfigurationParameters({
        @ConfigurationParameter(
        key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME,
        value="true"
        ),
        @ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "html:cucumber-reports/cucumber-reports.html"
)})
public class RunCucumberTest {
    private DriverProvider driverProvider;
    private PropertiesProvider propertiesProvider;
    @Before
    public void before(Scenario scenario)  {
        propertiesProvider = new PropertiesProvider();
        propertiesProvider.loadProperties();

        driverProvider = new DriverProvider();
        driverProvider.initDriver();
    }

    @AfterStep
    public void takeScreeshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) driverProvider.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png",  scenario.getName()); //stick it in the report
        //driverProvider.getDriver().close();
    }


    @AfterSuite
    public void teardown(){
        if(driverProvider.getDriver()!= null) {

            driverProvider.getDriver().quit();
        }
    }

}


