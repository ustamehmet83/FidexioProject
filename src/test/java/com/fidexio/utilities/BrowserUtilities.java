package com.fidexio.utilities;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtilities {

    public static void titleVerify(String title){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs(title));
        String expectedTitle = title;
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }
    public static void verifyTitleContains(String str){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs(Driver.getDriver().getTitle()));
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(str));
    }
}
