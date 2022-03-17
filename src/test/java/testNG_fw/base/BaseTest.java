package testNG_fw.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testNG_fw.factory.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
//    @BeforeMethod
    @BeforeClass
    public void startDriver(@Optional("chrome") String browser){
        driver = new DriverManager().intializeDriver(browser);
    }

//    @AfterMethod
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
}
