package testNG_fw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testNG_fw.base.BasePage;


public class CartPage extends BasePage {

    private By productName = By.cssSelector("td[class='product-name'] a");
    private By btn_CheckOut = By.cssSelector(".checkout-button.button.alt.wc-forward");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public CheckoutPage clkCheckOut(){
        driver.findElement(btn_CheckOut).click();
        return new CheckoutPage(driver);
    }
}
