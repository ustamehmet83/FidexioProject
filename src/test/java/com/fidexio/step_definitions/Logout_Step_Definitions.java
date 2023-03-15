package com.fidexio.step_definitions;

import com.fidexio.pages.DashBoardPage;
import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtilities;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout_Step_Definitions {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @When("User on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fidexio.url"));
    }

    @When("User on the dashboard")
    public void user_on_the_dashboard() {
        loginPage.login(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }

    @When("User click logout button")
    public void user_click_logout_button() {
        dashBoardPage.TopBarName.click();
        dashBoardPage.LogOutBtn.click();
    }

    @Then("User log out and back to the login page")
    public void user_log_out_and_back_to_the_login_page() {
        String expectedTitle = "Login | Best solution for startups";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    @And("User click the step back button")
    public void userClickTheStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("User can not go to the home page")
    public void userCanNotGoToTheHomePage() {

        String actualAlertText=dashBoardPage.popUpText.getText();
        String expectedAlertText="Odoo Session Expired";
        Assert.assertTrue(expectedAlertText.equals(actualAlertText));
    }
}
