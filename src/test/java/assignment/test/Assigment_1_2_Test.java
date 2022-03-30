package assignment.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import assignment.base.BaseTest;
import assignment.page.HomePage;

public class Assigment_1_2_Test extends BaseTest{
	
	@Test
    void verify_the_URLs() {
		
		HomePage hp = new HomePage(driver).load();
		
		hp.navigateToStore(); 
		Assert.assertTrue(hp.getURL().contains("store"), "Assert Error" + hp.getURL());
		
		hp.navigateToMen();
		Assert.assertTrue(hp.getURL().contains("men"), "Assert Error" + hp.getURL());
		
		hp.navigateToWomen();
		Assert.assertTrue(hp.getURL().contains("women"), "Assert Error" + hp.getURL());;
		
		hp.navigateToAccessories();
		Assert.assertTrue(hp.getURL().contains("accessories"), "Assert Error" + hp.getURL());
		
		hp.navigateToAccount();
		Assert.assertTrue(hp.getURL().contains("account"), "Assert Error" + hp.getURL());
		
		hp.navigateToContactUs();
		Assert.assertTrue(hp.getURL().contains("contact-us"), "Assert Error" + hp.getURL());
		
	}
	
	@Test
    void verify_the_CartCount() {
		
		HomePage hp = new HomePage(driver).load();
		
		hp.navigateToStore().click_AddToCart(); 
		
		String cartCount = hp.get_CartContainerItems();
		Assert.assertEquals(cartCount, "1", "Cart container count");
	}

}
