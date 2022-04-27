package testNG_fw.pages;

import org.openqa.selenium.By;
import testNG_fw.base.BasePage;
import testNG_fw.enums.WaitStrategy;

public class StorePage extends BasePage {

    private By fld_Search = By.cssSelector("#woocommerce-product-search-field-0");
    private By btn_Search = By.cssSelector("button[value='Search']");
    private By txt_SearchTitle = By.cssSelector(".woocommerce-products-header__title.page-title");
    // Below locator is dynamic to handle this separate method is created
    //private By btn_AddToCart1 = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private By btn_ViewCart = By.cssSelector("a[title='View cart']");


//    public StorePage(WebDriver driver) {
//        super(driver);
//    }

    public StorePage enterTextinSearch(String txt){
        sendKeys(fld_Search, txt, WaitStrategy.VISIBLE, "fld_Search");
        return this;
    }
    public StorePage clickSeachBtn(){
        //driver.findElement(btn_Search).click();
    	click(btn_Search, WaitStrategy.CLICKABLE, "btn_Search");
    	return this;
    }

    public String getSearchTitle(){
        //return waitElementToBeClickable(txt_SearchTitle).getText(); //driver.findElement(txt_SearchTitle).getText();
    	return getText(txt_SearchTitle, WaitStrategy.VISIBLE, "");
    }

    private By getAddToCartBtmElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");
    }

    public StorePage clickAddToCartBtn(String productName){
        //driver.findElement(getAddToCartBtmElement(productName)).click();
    	click(getAddToCartBtmElement(productName), WaitStrategy.CLICKABLE, "Add to Cart");
        return this;
    }

    public CartPage clickViewCart(){
        //waitElementToBeClickable(btn_ViewCart).click();
        click(btn_ViewCart, WaitStrategy.CLICKABLE, "");
        return new CartPage();
    }


}
