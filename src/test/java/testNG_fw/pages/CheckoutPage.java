package testNG_fw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testNG_fw.base.BasePage;
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

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFrstName(String txt){
        driver.findElement(frstName).sendKeys(txt);
        return this;
    }

    public CheckoutPage enterLastName(String txt){
        driver.findElement(lastName).sendKeys(txt);
        return this;
    }
    public CheckoutPage enterStreetAddr(String txt){
        driver.findElement(streetName).sendKeys(txt);
        return this;
    }
    public CheckoutPage enterCity(String txt){
        driver.findElement(fld_townName).sendKeys(txt);
        return this;
    }
    public CheckoutPage enterZip(String txt){
        driver.findElement(fld_zipCode).sendKeys(txt);
        return this;
    }
    public CheckoutPage enterEmail(String txt){
        driver.findElement(fld_email).sendKeys(txt);
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
        driver.findElement(btn_placeOrd).click();
        return this;
    }

    public String getConfirmationTxt(){
        getWebDriverWait(10).until(ExpectedConditions.visibilityOfElementLocated(title_Confimation));
        return driver.findElement(title_Confimation).getText();
    }
}
