package assignment.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import assignment.base.BasePage;


public class HomePage extends BasePage {

   private By link_Menu_Store = By.cssSelector("#menu-item-1227 > a");
   private By link_Menu_Men = By.linkText("Men");
   private By link_Menu_Women = By.linkText("Women");
   private By link_Menu_Accessories = By.linkText("Accessories");
   private By link_Menu_Account = By.xpath("//a[contains(text(),'Account')]");
   private By link_Menu_About = By.cssSelector("css=#menu-item-1232 > a.menu-link");
   private By link_Menu_ContactUs = By.linkText("Contact Us");
   
   private By ele_CartContainer = By.xpath("//*[@id=\"ast-site-header-cart\"]//a/div/span");
   

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public HomePage load() {
        load("/");
        return this;
    }

 // Fluent interface concept : Which will return the object of next page
    public StorePage navigateToStore(){
        //driver.findElement(link_Menu_Store).click();
    	_click(link_Menu_Store, "link_Menu_Store");
        return new StorePage(driver);
    }
    public HomePage navigateToMen(){
    	_click(link_Menu_Men, "Menu_Men");
        return this;
    }
    public HomePage navigateToWomen(){
    	_click(link_Menu_Women, "");
        return this;
    }
    public HomePage navigateToAccessories(){
    	_click(link_Menu_Accessories, "");
        return this;
    }
    public HomePage navigateToAccount(){
    	_click(link_Menu_Account, "");
        return this;
    }
    public HomePage navigateToAbout(){
    	_click(link_Menu_About, "");
        return this;
    }
    public HomePage navigateToContactUs(){
    	_click(link_Menu_ContactUs, "");
        return this;
    }

    public String get_CartContainerItems() {
    	return driver.findElement(ele_CartContainer).getText();
    }
    

}
