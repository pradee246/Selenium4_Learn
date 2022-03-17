package testNG_fw.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    /*
    Note : Keep this minimal, avoid added lots of methods
     */

    protected WebDriver driver;
    private WebDriverWait wait;

    private String sBaseURL = "https://askomdch.com";

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    public void load(String sEndPoint){
        driver.get(sBaseURL+sEndPoint);
    }

    public WebDriverWait getWebDriverWait(long l){
        return new WebDriverWait(driver, Duration.ofSeconds(l));
    }

    public WebElement waitVisibilityOfElement(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementToBeClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
