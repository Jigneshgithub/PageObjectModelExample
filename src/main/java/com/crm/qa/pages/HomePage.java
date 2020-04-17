package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
    WebElement usernameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    @CacheLookup
    WebElement  contactsLinks;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLinks;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle(){
       return driver.getTitle();
    }

    public boolean verifyCorrectUsername(){
        return usernameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLinks.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }

//    public void clickOnNewContactLink() throws InterruptedException {
////        try {
////            Thread.sleep(4000);
////        } catch (InterruptedException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        }
//        Thread.sleep(10000);
//        Actions action = new Actions(driver);
//        action.moveToElement(contactsLinks).build().perform();
//        action.moveToElement(contactsLinks).build().perform();
//        newContactLinks.click();
//
//    }


}
