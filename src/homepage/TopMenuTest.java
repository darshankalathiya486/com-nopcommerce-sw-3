package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 1. create class "TopMenuTest"
 *      1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 *      1.2 This method should click on the menu whatever name is passed as parameter.
 *      1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */

public class TopMenuTest extends Utility {

    // Declare baseUrl
    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }


    // Create method with name "selectMenu" and parameter
    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
        for (WebElement element : topMenuList) {
            if (element.getText().trim().equalsIgnoreCase(menu)) {
                clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']"));
                break;
            }
        }

    }


    @Test
    public void verifyPageNavigation() {
            String menu = "Computers";
            selectMenu(menu);
            String expectedTitle = getTextFromElement(By.xpath("//h1[normalize-space()='" + menu + "']"));
            String axpectedTitle = menu;
            Assert.assertEquals(expectedTitle, axpectedTitle);
        }

    @After
    public void tearDown() {
        closeBrowser();
    }


    }

