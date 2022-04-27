package testNG_fw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testNG_fw.base.BasePage;
import testNG_fw.enums.WaitStrategy;
//import org.selenium.pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {

    private By frstName = By.cssSelector("#billing_first_name");
    private By lastName = By.cssSelector("#billing_last_name");
    private By streetName = By.cssSelector("#billing_address_1");
    private By fld_townName = By.cssSelector("#billing_city");
    private By fld_zipCode = By.cssSelector("#billing_postcode");
    private By fld_email = By.cssSelector("#billing_email");
    private By btn_placeOrd = By.cssSelector("#place_order");
    private By title_Confimation = By.cssSelector(".woocommerce-notice");

//    public CheckoutPage(WebDriver driver) {
//        super(driver);
//    }

    public CheckoutPage enterFrstName(String txt){
    	sendKeys(frstName, txt, WaitStrategy.VISIBLE, "");
        //driver.findElement(frstName).sendKeys(txt);
        return this;
    }

    public CheckoutPage enterLastName(String txt){
    	sendKeys(lastName, txt, WaitStrategy.VISIBLE, "");
        return this;
    }
    public CheckoutPage enterStreetAddr(String txt){
    	sendKeys(streetName, txt, WaitStrategy.VISIBLE, "");
        return this;
    }
    public CheckoutPage enterCity(String txt){
    	sendKeys(fld_townName, txt, WaitStrategy.VISIBLE, "");
        return this;
    }
    public CheckoutPage enterZip(String txt){
    	sendKeys(fld_zipCode, txt, WaitStrategy.VISIBLE, "");
        return this;
    }
    public CheckoutPage enterEmail(String txt){
    	sendKeys(fld_email, txt, WaitStrategy.VISIBLE, "");
        return this;
    }

    public CheckoutPage setBillingDetails(String fName, String lName, String addr, String city, String zip, String email){
        return  enterFrstName(fName).
                enterLastName(lName).
                enterStreetAddr(addr).
                enterCity(city).
                enterZip(zip).
                enterEmail(email);
    }

    public CheckoutPage clickPlaceOrder(){
    	click(btn_placeOrd, WaitStrategy.CLICKABLE, "btn_placeOrd");
        return this;
    }

    public String getConfirmationTxt(){
    	return getText(title_Confimation, WaitStrategy.VISIBLE, "title_Confimation");
    }
}
