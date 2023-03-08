package com.fidexio.step_definitions;

import com.fidexio.pages.DashBoardPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_Step_Definitions {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();


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
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        String expectedTitle="#Inbox - Odoo";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTitle.equals(expectedTitle));
    }


    @When("user enters invalid mail {string} or {string}")
    public void userEntersInvalidMailOr(String email, String password) {
        loginPage.login(email,password);
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String arg0) {
        System.out.println("loginPage.alertMessage.getText() = " + loginPage.alertMessage.getText());
    }
}
