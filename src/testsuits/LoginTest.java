package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='authorization-link'][1]")).click();
        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("Boradm@gmail.com");
        //Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("Maitri@123");
        //Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();
        //Verify the ‘Welcome’ text is display
        String actualText=driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText();
        String expectedText="Welcome";
        Assert.assertTrue("Text not displayed",actualText.contains(expectedText));
    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='authorization-link'][1]")).click();
        //Enter invalid Email
        driver.findElement(By.id("email")).sendKeys("vghftj@gmail.com");
        //Enter invalid Password
        driver.findElement(By.id("pass")).sendKeys("hgccb");
        //Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();
        //Verify the error message ‘The account sign-in was
        //incorrect or your account is disabled temporarily. Please wait and try again later.’
        String actualMessage=driver.findElement(By.xpath("//div[@class='message-error error message']")).getText();
        String expectedText="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        Assert.assertEquals("Message not displayed correctly",expectedText,actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='authorization-link'][1]")).click();
        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("Boradm@gmail.com");
        //Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("Maitri@123");
        //Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();
        //Verify the ‘Welcome’ text is display
        String actualText=driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText();
        String expectedText="Welcome";
        Assert.assertTrue("Text not displayed",actualText.contains(expectedText));
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
