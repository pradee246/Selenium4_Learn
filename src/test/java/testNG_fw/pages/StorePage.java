package testNG_fw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testNG_fw.base.BasePage;

public class StorePage extends BasePage {

    private By fld_Search = By.cssSelector("#woocommerce-product-search-field-0");
    private By btn_Search = By.cssSelector("button[value='Search']");
    private By txt_SearchTitle = By.cssSelector(".woocommerce-products-header__title.page-title");
    // Below locator is dynamic to handle this separate method is created
    //private By btn_AddToCart1 = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private By btn_ViewCart = By.cssSelector("a[title='View cart']");


    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage enterTextinSearch(String txt){
        //waitElementToBeClickable(fld_Search).sendKeys(txt);
        //driver.findElement(fld_Search).sendKeys(txt);
    	_sendKeys(fld_Search, txt, "fld_Search");
        return this;
    }
    public StorePage clickSeachBtn(){
        //driver.findElement(btn_Search).click();
    	_click(btn_Search, "btn_Search");
    	return this;
    }

    public String getSearchTitle(){
        //return waitElementToBeClickable(txt_SearchTitle).getText(); //driver.findElement(txt_SearchTitle).getText();
    	return _getText(txt_SearchTitle, "");
    }

    private By getAddToCartBtmElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");
    }

    public StorePage clickAddToCartBtn(String productName){
        //driver.findElement(getAddToCartBtmElement(productName)).click();
    	_click(getAddToCartBtmElement(productName), "Add to Cart");
        return this;
    }

    public CartPage clickViewCart(){
        //waitElementToBeClickable(btn_ViewCart).click();
        _click(btn_ViewCart, "");
        return new CartPage(driver);
    }


}
