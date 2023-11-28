package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 *      1.1 Click on Computer Menu.
 *      1.2 Click on Desktop
 *      1.3 Select Sort By position "Name: Z to A"
 *      1.4 Verify the Product will arrange in Descending order.
 * 2.Test name verifyProductAddedToShoppingCartSuccessFully()
 */

public class TestSuite extends Utility {

    // Declare baseUrl
    String baseUrl = "https://demo.nopcommerce.com/";

    // open browser
    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    // Method name verifyProductArrangeInAlphaBaticalOrder

    public void verifyProductArrangeInAlphaBaticalOrder() {
        // click on Computer Menu
        clickMethod(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        // click on Desktop
        clickMethod(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));

        //  Select Sort By position "Name: Z to A"
        selectByValueFromDropdown(By.xpath("//select[@id='products-orderby']"),"6");

        // Capture the product prices
        List<WebElement> productPriceElements = driver.findElements(By.cssSelector(".product-price"));
        List<Double> productPrices = new ArrayList<>();
        for (WebElement element : productPriceElements) {
            // Extract the price from the element and convert it to a double
            double price = Double.parseDouble(element.getText().replace("$", ""));
            productPrices.add(price);
        }

        // Check if the product prices are in descending order
        List<Double> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices, Collections.reverseOrder());
        Assert.assertEquals(productPrices, sortedPrices);

        // Sleep added for visualization, you might want to replace this with a wait strategy
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    // Method name verifyProductAddedToShoppingCartSuccessFully
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //  Click on Computer Menu
        clickMethod(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        // Click on Desktop
        clickMethod(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));

        // Select Sort By position "Name: A to Z"
        selectByValueFromDropdown(By.xpath("//select[@id='products-orderby']"),"5");
        Thread.sleep(2000);

        //  Click on "Add To Cart"
        clickMethod(By.xpath("(//div[@class='buttons'])[1]"));

        // Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        Assert.assertEquals(expectedText,actualText);

        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropdown(By.xpath("//select[@id='product_attribute_1']"),"1");

        //Select "8GB [+$60.00]" using Select class
        selectByValueFromDropdown(By.xpath("//select[@id='product_attribute_2']"), "5");

        //Select HDD radio "400 GB [+$100.00]"
        clickMethod(By.xpath("//input[@value='7']"));

        //Select OS radio "Vista Premium [+$60.00]"
        clickMethod(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(2000);

        // Check Two Check boxes "Total Commander [+$5.00]"
        clickMethod(By.xpath("//input[@id='product_attribute_5_12']"));

        // Check Two Check boxes "Microsoft Office [+$50.00]"
       List<WebElement> selectCheckBox = driver.findElements(By.xpath("//dd[@id='product_attribute_input_5']//li[1]"));
       for (WebElement element : selectCheckBox) {
           if (element.getText().equalsIgnoreCase("Microsoft Office [+$50.00]")) ;
           element.click();
           break;
       }

       // Verify the price "$1,475.00"
        String expectedText1 = "$1,475.00";
        String actualText1 = getTextFromElement(By.xpath("//span[text() = '$1,475.00']"));
        Assert.assertEquals(expectedText1,actualText1);

        //  Click on "Add To Cart"
        clickMethod(By.id("add-to-cart-button-1"));

        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText2 = "The product has been added to your shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText2,actualText2);

        // Close the bar by clicking on the cross button
        clickMethod(By.xpath("//span[@title='Close']"));

        //  Then MouseHover on "Shopping cart".
        mouseHoverToBuild(By.xpath("//li[@id='topcartlink']"));

        //  Click on "GO TO CART" button.
        clickMethod(By.xpath("//button[normalize-space()='Go to cart']"));

        // Verify the message "Shopping cart"
        String expectedText3 = "Shopping cart";
        String actualText3 = getTextFromElement(By.xpath("//h1[text() = 'Shopping cart']"));

        //Change the Qty to "2" and Click on "Update shopping cart
        clickMethod(By.xpath("//td[@class='quantity']//input"));
        Thread.sleep(2000);

        //clear input value in field
        clearInput(By.xpath("//td[@class='quantity']//input"));
        sendTextToElement(By.xpath("//td[@class='quantity']//input"),"2");
        clickMethod(By.xpath("//button[@id='updatecart']"));

        //Verify the Total"$2,950.00"
        String expectedText4 = "$2,950.00";
        String actualText4 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals(expectedText4,actualText4);

        // click on checkbox “I agree with the terms of service”
        clickMethod(By.xpath("//input[@id='termsofservice']"));

        // Click on “CHECKOUT”
        clickMethod(By.xpath("//button[@id='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        String expectedText5 = "Welcome, Please Sign In!";
        String actualText5 = getTextFromElement(By.xpath("//h1[text()= 'Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText5,actualText5);

        //Click on “CHECKOUT AS GUEST” Tab
        clickMethod(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        // Fill the all mandatory field
        // First name
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Meet");
        // Last name
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        // Email
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"abcd123@gmail.com");
        // Country
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"1");
        // state
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"53");
        //Address
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"dddddddd");
        // City
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Mexico");
        //Zip cord
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "12345");
        // phone number
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"1234567890");

        // Click on “CONTINUE”
        clickMethod(By.xpath("//button[@onclick='Billing.save()']"));

        // Click on Radio Button “Next Day Air($0.00)
        clickMethod(By.xpath("//div[@class='method-name']//label[text() = 'Next Day Air ($0.00)']"));

        // Click on “CONTINUE”
        clickMethod(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        // Select Radio Button “Credit Card”
        clickMethod(By.xpath("//label[normalize-space()='Credit Card']"));

        // Click on “CONTINUE”
        clickMethod(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //Select “Master card” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");

        // Fill all the details
        // Cardholder name
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Meet Patel");
        //card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5555 5537 5304 8194");
        //select expira date
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"),"5");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"),"2030");
        // code
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"234");

        // Click on “CONTINUE”
        clickMethod(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //Verify “Payment Method” is “Credit Card”
        String expectedText6 = "Payment Method: Credit Card";
        String actualText6= getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedText6,actualText6);

        //Verify “Shipping Method” is “Next Day Air”
        String expectedText7 = "Shipping Method: Next Day Air";
        String actualText7 = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals(expectedText7,actualText7);

        // Verify Total is “$2,950.00”
        String expectedText8 ="$2,950.00";
        String actualText8 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals(expectedText8,actualText8);

        // Click on “CONFIRM”
        clickMethod(By.xpath("//button[normalize-space()='Confirm']"));

        //Verify the Text “Thank You”
        String expectedText9 = "Thank you";
        String actualText9 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedText9,actualText9);

        //Verify the message “Your order has been successfully processed!”
        String expectedText10 = "Your order has been successfully processed!";
        String actualText10= getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText10,actualText10);

        //Click on “CONTINUE”
        clickMethod(By.xpath("//button[normalize-space()='Continue']"));

        //Verify the text “Welcome to our store”
        String expectedText11 = "Welcome to our store";
        String actualText11 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedText11,actualText11);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
