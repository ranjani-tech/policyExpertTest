package com.policyexpertquote.web.helper;

import com.policyexpertquote.web.constants.BrowserConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class DriverProvider {

    private static WebDriver driver;

    public void initDriver(){
            driver = createDriver(PropertiesProvider.getProperties().getProperty("browser"));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static final String PREFS = "prefs";
    private static final String JAVASCRIPT_SETTINGS =
            "profile.managed_default_content_settings.javascript";
    private static final short DISABLED = 2;
    private Map<String, Object> getChromePrefs() {
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put(JAVASCRIPT_SETTINGS, DISABLED);
        return chromePrefs;
    }
    private static final String JAVASCRIPT_ENABLED = "javascript.enabled";

    private WebDriver createDriver(String browserName) {
        switch (browserName) {
            case BrowserConstants.CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chOption = new ChromeOptions();
                chOption.addArguments("--disable-gpu");
                //chOption.setExperimentalOption(PREFS, getChromePrefs());

                //chOption.addArguments("enable-automation");
                //chOption.addArguments("--window-size=1920,1080");
                //chOption.addArguments("--no-sandbox");
                //chOption.addArguments("--disable-extensions");
                //chOption.addArguments("--dns-prefetch-disable");
                //chOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chOption);
                break;
            case BrowserConstants.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fxOption = new FirefoxOptions();
                //fxOption.addPreference(JAVASCRIPT_ENABLED, false);

                driver = new FirefoxDriver(fxOption);

                break;
            case BrowserConstants.EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

                break;
            case BrowserConstants.OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();

                break;
            default:
                throw new IllegalStateException("UNEXPECTED_VALUE" + browserName);
        }
        Set<Cookie> allcookies = driver.manage().getCookies();
        System.out.println("allcookies"+allcookies);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5L,1L));
        //driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3L,1L));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L,1L));
        return driver;
    }
}
