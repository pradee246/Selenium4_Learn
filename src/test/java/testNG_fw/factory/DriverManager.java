package testNG_fw.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverManager {

/*    public WebDriver intializeDriver(){
        //System.setProperty("webdriver.chrome.driver","C:\\Automation\\Temp\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    */

    public WebDriver intializeDriver(String browser){
        //String browser = System.getProperty("browser","chrome"); // picks the hard coded value i.e chrome, if the value is not passed from MVN CMD
        browser = System.getProperty("browser",browser); // picks the default value passed from TestNG.xml, if the value is not passed from MVN CMD
        WebDriver driver;
        switch(browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name: "+browser);
        }
        return driver;
    }
}
