package com.crm.qa.testCases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    TasksPage tasksPage;
    DealsPage dealsPage;

    public HomePageTest(){
        super();
    }

    // test case should be separated -- independent with each other
    // before each test case -- launch the browser and login
    // @test -- execute test case
    // after each test case -- close the browser

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        tasksPage = new TasksPage();
        dealsPage = new DealsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"CRMPRO","Home Page title not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameTest(){
//        boolean flag = homePage.verifyCorrectUsername();
//        Assert.assertTrue(flag);
        // or
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUsername());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }




}
