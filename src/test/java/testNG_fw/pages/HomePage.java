package testNG_fw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testNG_fw.base.BasePage;
import testNG_fw.enums.WaitStrategy;

public class HomePage extends BasePage {

   private By link_Menu_Store = By.cssSelector("#menu-item-1227 > a");

//    public HomePage(WebDriver driver) {
//        super(driver);
//    }

 // Fluent interface concept : Which will return the object of next page
    public StorePage navigateToStore(){
        //driver.findElement(link_Menu_Store).click();
    	click(link_Menu_Store, WaitStrategy.CLICKABLE, "link_Menu_Store");
        return new StorePage();
    }

    public HomePage load() {
        load("/");
        return this;
    }
}
