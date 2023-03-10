package com.fidexio.utilities;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtilities {

    public static void titleVerify(){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        String expectedTitle = "#Inbox - Odoo";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTitle.equals(expectedTitle));
    }
}
