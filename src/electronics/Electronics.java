package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 *      1.1 Mouse Hover on “Electronics” Tab
 *      1.2 Mouse Hover on “Cell phones” and click
 *      1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 */

public class Electronics extends Utility {

    // Declare baseUrl
    String baseUrl = "https://demo.nopcommerce.com/";

    // open browser
    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    // Method name verifyUserShouldNavigateToCellPhonesPageSuccessfully
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

        // Mouse Hover on “Electronics” Tab
        mouseHoverToBuild(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        // Mouse Hover on “Cell phones” and click
        mouseHoverToBuild(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickMethod(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        // Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    // Method name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException{

        // Mouse Hover on “Electronics” Tab
        mouseHoverToBuild(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        // Mouse Hover on “Cell phones” and click
        mouseHoverToBuild(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clickMethod(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        // Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expectedText,actualText);

        // Click on List View Tab
        clickMethod(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(2000);

        //  Click on product name “Nokia Lumia 1020” link
        clickMethod(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        // Verify the text “Nokia Lumia 1020”
        String expectedText0 = "Nokia Lumia 1020";
        String actualText0 = getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        Assert.assertEquals(expectedText0,actualText0);

        //Verify the price “$349.00”
        String expectedText1 = "$349.00";
        String actualText1 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expectedText1,actualText1);

        // Change quantity to 2
        clickMethod(By.xpath("//input[@id='product_enteredQuantity_20']"));
        clearInput(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        // Click on “ADD TO CART” tab
        clickMethod(By.xpath("//button[@id='add-to-cart-button-20']"));

        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText2 = "The product has been added to your shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedText2,actualText2);

        // Close the bar by clicking on the cross button
        clickMethod(By.xpath("//span[@title='Close']"));

        // Then MouseHover on "Shopping cart".
        mouseHoverToBuild(By.xpath("//li[@id='topcartlink']"));

        // Click on "GO TO CART" button.
        clickMethod(By.xpath("//button[normalize-space()='Go to cart']"));

        // Verify the message "Shopping cart"
        String expectedText3 = "Shopping cart";
        String actualText3 = getTextFromElement(By.xpath("//h1[text() = 'Shopping cart']"));

        // Verify the quantity is 2
        String expectedText4 = "2";
        String actualText4 = driver.findElement(By.xpath("//input[@class ='qty-input']")).getAttribute("value");
        Assert.assertEquals(expectedText4,actualText4);

        //   Verify the Total $698.00
        String expectedText5 = "$698.00";
        String actualText5 = getTextFromElement(By.xpath("//span[text() ='$698.00']"));
        Assert.assertEquals(expectedText5,actualText5);

        // click on checkbox “I agree with the terms of service”
        clickMethod(By.xpath("//input[@id='termsofservice']"));

        // Click on “CHECKOUT”
        clickMethod(By.xpath("//button[@id='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        String expectedText6 = "Welcome, Please Sign In!";
        String actualText6 = getTextFromElement(By.xpath("//h1[text()= 'Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText6,actualText6);

        // Click on “REGISTER” tab
        clickMethod(By.xpath("//button[normalize-space()='Register']"));

        // Verify the text “Register”
        String expectedText7 = "Register";
        String actualText7 = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals(expectedText7,actualText7);

        // Fill the mandatory fields
        // First name
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Nill");
        // Last name
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Patel");
        // Email
        sendTextToElement(By.xpath("//input[@id='Email']"), "hldbh@gmail.com");
        //Password
        sendTextToElement(By.xpath("//input[@id='Password']"), "123456789");
        //Confirm
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "123456789");

        //Click on “REGISTER” Button
        clickMethod(By.xpath("//button[@id='register-button']"));

        // Verify the message “Your registration completed”
        String expectedText8 = "Your registration completed";
        String actualText8 = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedText8,actualText8);

        // Click on “CONTINUE” tab
        clickMethod(By.xpath("//a[normalize-space()='Continue']"));

        //Verify the text “Shopping card”
        String expectedText9 = "Shopping cart";
        String actualText9 = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedText9,actualText9);

        //login click
        clickMethod(By.xpath("//a[normalize-space()='Log in']"));

        // add email
        sendTextToElement(By.xpath("//input[@id='Email']"), "hldbh@gmail.com");

        // add password
        sendTextToElement(By.xpath("//input[@id='Password']"), "123456789");

        // click on login button
        clickMethod(By.xpath("//button[normalize-space()='Log in']"));

        // click on checkbox “I agree with the terms of service”
        clickMethod(By.xpath("//input[@id='termsofservice']"));

        // Click on “CHECKOUT”
        clickMethod(By.xpath("//button[@id='checkout']"));

        // Fill the all mandatory field
        // First name
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

        // Click on Radio Button “2nd Day Air ($0.00)”
        clickMethod(By.xpath("//label[normalize-space()='2nd Day Air ($0.00)']"));

        // Click on “CONTINUE”
        clickMethod(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        // Select Radio Button “Credit Card”
        clickMethod(By.xpath("//label[normalize-space()='Credit Card']"));

        // Click on “CONTINUE”
        clickMethod(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //Select “Master card” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"), "visa");

        // Fill all the details
        // Cardholder name
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Meet Patel");
        //card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"4012 8888 8888 1881");
        //select expira date
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"),"5");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"),"2030");
        // code
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"234");

        // Click on “CONTINUE”
        clickMethod(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //Verify “Payment Method” is “Credit Card”
        String expectedText10 = "Payment Method: Credit Card";
        String actualText10= getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedText10,actualText10);

        //Verify “Shipping Method” is “Next Day Air”
        String expectedText11 = "Shipping Method: 2nd Day Air";
        String actualText11 = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals(expectedText11,actualText11);

        // Verify Total is “$698.00”
        String expectedText12 ="$698.00";
        String actualText12 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        Assert.assertEquals(expectedText12,actualText12);

        // Click on “CONFIRM”
        clickMethod(By.xpath("//button[normalize-space()='Confirm']"));

        //Verify the Text “Thank You”
        String expectedText13 = "Thank you";
        String actualText13 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedText13,actualText13);

        //Verify the message “Your order has been successfully processed!”
        String expectedText14 = "Your order has been successfully processed!";
        String actualText14= getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedText14,actualText14);

        //Click on “CONTINUE”
        clickMethod(By.xpath("//button[normalize-space()='Continue']"));

        //Verify the text “Welcome to our store”
        String expectedText15 = "Welcome to our store";
        String actualText15 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedText15,actualText15);

        // Click on “Logout” link
        clickMethod(By.xpath("//a[normalize-space()='Log out']"));

        // Verify the URL is “https://demo.nopcommerce.com/”
        String expectedText16 = "https://demo.nopcommerce.com/";
        String actualText16 = baseUrl;
        Assert.assertEquals(expectedText16,actualText16);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
