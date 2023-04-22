package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage(){
        //Click on ‘Sale’ Menu tab
        driver.findElement(By.id("ui-id-8")).click();
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.linkText("Jackets")).click();
        //Verify the text ‘Jackets’ is displayed
        String actualText=driver.findElement(By.xpath("//span[@class='base']")).getText();
        String expectedText="Jackets";
        Assert.assertEquals("Displayed not correctly",expectedText,actualText);
        //Count the Total Item Displayed on Page and print the name of all items into console.
        List<WebElement> list=driver.findElements(By.xpath("//img[@class='product-image-photo']"));
        System.out.println("Items displayed on the page are: "+list.size());
        List<WebElement> names=driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        //iterate webElement and print it
        for (WebElement name:names) {
            System.out.println(name.getText());
        }
        //Verify total 12 Items displayed on page.
        List<WebElement> list1=driver.findElements(By.xpath("//img[@class='product-image-photo']"));
        int actualNo= list1.size();
        int expectedNo=12;
        Assert.assertEquals("Product not displayed correctly",expectedNo,actualNo);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
