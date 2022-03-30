package assignment.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(priority=0, description = "F1 is set to verify priority")
  public void f1() {
	  System.out.println("This is the f 1");
	  
  }
  @Test(priority=-1)
  public void f2() {
	  System.out.println("This is the f 2");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeclass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterclass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");
  }

}
