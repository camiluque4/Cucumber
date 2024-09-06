package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

class IsItFriday {
    static String isItFriday(String today) {
        String s = "Friday".equals(today) ? "TGIF" : "Nope";
        return s;
    }


}

public class StepDefinitions {
    WebDriver driver = CucumberHooks.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    private String today;
    private String actualAnswer;
    @Given("today is Sunday")
    public void todayIsSunday() {
        today ="Sunday";
    }
    @Given("today is Friday")
    public void todayIsFriday() {
        today= "Friday";
    }

    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("^The user write the username (.*) and the password (.*)$")
    public void theUserWriteTheUsernameUSER_NAMEAndThePasswordPASSWORD(String username,String password) {
        loginPage.loginUser(username,password);
    }
}
