package testNG_fw.factory;

import java.util.Objects;

import org.openqa.selenium.WebDriver;


public final class DriverManager {

    private DriverManager(){}

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    static void setDriver(WebDriver driverRef){
    	if(Objects.nonNull(driverRef)) dr.set(driverRef);
    }

    static void unload(){
        dr.remove();
    }

}