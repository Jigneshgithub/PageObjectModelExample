package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // PageFactory  or ObjectRepository

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@class='btn btn-small']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
    WebElement crmLogo;

    // Initializing the PageObject

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    // Actions

    public String validateLoginPage(){
        return driver.getTitle();
    }

    public boolean validateCrmImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }

}
