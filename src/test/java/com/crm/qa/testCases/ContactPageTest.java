package com.crm.qa.testCases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    String sheetName = "contacts";

    public ContactPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
//        testUtil.defaultFromSwitchFrame();
//        testUtil.switchToFrame();
    }

    @Test(priority = 1)
    public void verifyContactsPageLabelTest(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact label is missing in the page");
    }

    @Test(priority = 2)
    public void selectSingleContactsTest(){
        contactsPage.selectContactsByName("abc xyz");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest(){
        contactsPage.selectContactsByName("Aakash Shah");
        contactsPage.selectContactsByName("Ajay Kumar");
    }

//    @DataProvider
//    public Object[][] getCrmTestData(){
//        Object data [][] = TestUtil.getTestData(sheetName);
//        return data;
//    }
//
//    @Test(priority = 4,dataProvider = "getCrmTestData")
//    public void validateCreateNewContact(String title, String firstname, String lastname, String company) throws InterruptedException {
//        contactsPage.clickOnNewContactLink();
////        contactsPage.createNewContact("Mr.","Jignesh","Wala","Abc Entertainment"); // hardcoded value
//        contactsPage.createNewContact(title,firstname,lastname,company);
//    }

    @Test(priority = 4)
    public void validateCreateNewContact() throws InterruptedException {
//        testUtil.switchToFrame();
        contactsPage.clickOnNewContactLink();
        contactsPage.createNewContact("Mr.","Jignesh","Wala","Abc Entertainment"); // hardcoded value
    }


//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }


}
