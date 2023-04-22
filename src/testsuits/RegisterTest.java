package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void verifyThatSignInPageDisplay(){
       //click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        //Verify the text ‘Create New Customer Account’
        String actualText=driver.findElement(By.xpath("//span[text()='Create New Customer Account']")).getText();
        String expectedText="Create New Customer Account";
        Assert.assertEquals("Not displayed correctly",expectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        //Enter First name
        driver.findElement(By.id("firstname")).sendKeys("Maitri");
        //Enter Last name
        driver.findElement(By.id("lastname")).sendKeys("Borad");
        //Click on checkbox Sign Up for Newsletter
        driver.findElement(By.name("is_subscribed")).click();
        //Enter Email
        String email= "random-" + UUID.randomUUID().toString() + "@example.com";
        driver.findElement(By.name("email")).sendKeys(email);
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("Maitri@123");
        //Enter Confirm Password
        driver.findElement(By.id("password-confirmation")).sendKeys("Maitri@123");
        //Click on Create an Account button
        driver.findElement(By.xpath("//button[@type='submit' and @title='Create an Account']")).click();
        //Verify the text 'Thank you for registering with Main Website Store.'
        String actualText=driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();
        String expectedText="Thank you for registering with Main Website Store.";
        Assert.assertEquals("Registration not successfully",expectedText,actualText);
        //Click on down aero near Welcome
        driver.findElement(By.xpath("//span[@class='customer-name'][1]")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("//li[@class='authorization-link'][1]")).click();
        //Verify the text ‘You are signed out’
        String actualMessage=driver.findElement(By.xpath("//*[@ data-ui-id='page-title-wrapper']")).getText();
        String expectedMessage="You are signed out";
        Assert.assertEquals("Not signed out",expectedMessage,actualMessage);
    }
    @After
    public void tearDown() {
       closeBrowser();
    }
}