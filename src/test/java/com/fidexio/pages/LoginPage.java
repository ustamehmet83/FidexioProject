package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='login']")
    public WebElement loginUser;
    @FindBy(xpath="//input[@id='password']")
    public WebElement loginPass;
    @FindBy (xpath = "//button[.='Log in']")
    public WebElement loginBtn;

    @FindBy (xpath = "//p[normalize-space()='Wrong login/password']")
    public WebElement alertMessage;

    @FindBy (xpath = "//*[.='Reset Password']")
    public WebElement resetPasswordBtn;

    public void login(String email,String password){
        loginUser.sendKeys(email);
        loginPass.sendKeys(password);
    }



}
