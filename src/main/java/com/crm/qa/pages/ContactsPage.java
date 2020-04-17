package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends TestBase {

    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='surname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='client_lookup']")
    WebElement company;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveBtn;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    @CacheLookup
    WebElement contactsLinks;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    @CacheLookup
    WebElement newContactLinks;



    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public void selectContactsByName(String name){
        driver.findElement(By.xpath("//a[text()='"+ name +"']/../..//input[@name='contact_id']")).click();
//        driver.findElement(By.xpath("//a[text()='Aakash Shah']/../..//input[@name='contact_id']")).click();
    }

    public void clickOnNewContactLink() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
//        WebDriverWait wait = new WebDriverWait (driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated((By) contactsLinks));
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        Thread.sleep(10000);
        Actions action = new Actions(driver);
        action.moveToElement(contactsLinks).build().perform();
        action.moveToElement(contactsLinks).build().perform();
        newContactLinks.click();
//        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
//        driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();

    }


    public void createNewContact(String title,String ftName,String  ltName,String comp){
        Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
        select.selectByVisibleText(title);
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        company.sendKeys(comp);
//        saveBtn.click();

    }
}
