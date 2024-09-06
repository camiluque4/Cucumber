package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   WebDriver driver;
   By inputUserName = By.xpath(LoginContants.INPUT_USER_NAME);
   By inputPassword = By.xpath(LoginContants.INPUT_PASSWORD);
   By logginButton = By.xpath(LoginContants.LOGGIN_BUTTOM);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void loginUser(String username, String password) {
        driver.findElement(inputUserName).sendKeys(username);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(logginButton).click();
    }
}
