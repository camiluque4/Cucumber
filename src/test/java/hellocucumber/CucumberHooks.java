package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class CucumberHooks {
    public static ThreadLocal <WebDriver> tlDriver = new ThreadLocal<>();
    @Before
    public void startsChromeDriver (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        tlDriver.set(new ChromeDriver(options));
        getDriver().get("https://www.saucedemo.com/v1/");
    }

    public static  synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
    @After
    public void closeBrowser(){
        getDriver().quit();
    }
}
