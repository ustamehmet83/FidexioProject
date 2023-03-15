package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement fullName;
    @FindBy (xpath = "//a[.='Log out']")
    public WebElement logOutLink;

    public void logout(){
        fullName.click();
        logOutLink.click();
    }
    @FindBy (xpath = "//span[@class='oe_topbar_name']")
    public WebElement TopBarName;

    @FindBy (xpath = "//a[.='Log out']")
    public WebElement LogOutBtn;

    @FindBy (xpath = "//h4[.='Odoo Session Expired']")
    public WebElement popUpText;




}
