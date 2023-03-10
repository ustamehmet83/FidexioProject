package com.fidexio.step_definitions;

import com.fidexio.pages.DashBoardPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtilities;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_Step_Definitions {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();


    @Given("User is on login page")
    public void userIsOnLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fidexio.url"));

    }

    @When("user enters valid email {string}")
    public void userEntersValidEmail(String email) {
        loginPage.loginUser.sendKeys(email);
    }

    @And("user enters valid password {string}")
    public void userEntersValidPassword(String password) {
        loginPage.loginPass.sendKeys(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("user should be on the dashboard")
    public void user_should_be_on_the_dashboard() {
       BrowserUtilities.titleVerify();
    }

    @When("user enters invalid mail {string} or password{string}")
    public void userEntersInvalidMailOrPassword(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String expectedWrongText) {
        String actualWrongText = loginPage.alertMessage.getText();
        Assert.assertTrue(expectedWrongText.equals(actualWrongText));
    }


    @When("user enters empty mail {string} or password{string}")
    public void userEntersEmptyMailOrPassword(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {

        String actualMessageEmail = loginPage.loginUser.getAttribute("validationMessage");
        String actualMessage=actualMessageEmail;
        String actualMessagePassword=loginPage.loginPass.getAttribute("validationMessage");
        if (actualMessageEmail.isEmpty()){
            actualMessage=actualMessagePassword;

        }
        System.out.println(actualMessage);
        Assert.assertTrue(expectedMessage.equals(actualMessage));

    }

    @And("user press enter key of the keyboard")
    public void userPressEnterKeyOfTheKeyboard() {
        loginPage.loginBtn.sendKeys(Keys.ENTER);
        BrowserUtilities.titleVerify();

    }

    @Then("user see the password in bullet signs")
    public void userSeeThePasswordInBulletSigns() {
        String actualPasswordType="password";
        String expectedPasswordType=loginPage.loginPass.getAttribute("type");
        Assert.assertTrue(actualPasswordType.equals(expectedPasswordType));
    }
}
