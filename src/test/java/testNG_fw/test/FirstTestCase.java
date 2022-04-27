package testNG_fw.test;

import testNG_fw.base.BaseTest;
import testNG_fw.pages.*;
import testNG_fw.reports.ExtentLogger;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(testNG_fw.listener.Listener.class)	

public class FirstTestCase extends BaseTest {

    @Test
    void getCheckOutUsingDirectTransfer() throws InterruptedException, IOException {
    	
    	//ReportExtents.createTest("Test CheckOutUsingDirectTransfer");

//        BillingAddress billingAddress = new BillingAddress("demo", "user3", "Street name", "NewCity", "90011", "go@go.com");
//        billingAddress.
//                setFirstName("demo").
//                setLastName("user2").
//                setAddressLineOne("Street number 1").
//                setCity("Blore").
//                setZipCode("90011").
//                setEmail("go@go.com");

        StorePage storePage = new HomePage().load().navigateToStore();

        //storePage.enterTextinSearch("Blue");
        //storePage.clickSeachBtn();
        storePage.
                enterTextinSearch("Blue").
                clickSeachBtn(); // Above 2 lines are replaced by returning storePage object

        // Assert 
        Assert.assertEquals(storePage.getSearchTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        //Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();

        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clkCheckOut();
        checkoutPage.
                setBillingDetails("demo", "user3", "Street name", "NewCity", "90011", "go@go.com").
                clickPlaceOrder();
        //Thread.sleep(5000);
   
        Assert.assertEquals(checkoutPage.getConfirmationTxt(), "Thank you. Your order has been received.");
        Assertions.assertThat(checkoutPage.getConfirmationTxt())
        	.startsWith("Thank you.")
        	.endsWith("Your order has been received.")
        	.isMixedCase();
    }

    @Test
    void secondTest(){
    	StorePage storePage = new HomePage().load().navigateToStore();

        ExtentLogger.fail("This is fail step1");
        storePage.
                enterTextinSearch("Blue").
                clickSeachBtn(); // Above 2 lines are replaced by returning storePage object
        storePage.getSearchTitle();
        
        System.out.println("---------------- Executing 2nd test ------------------");
        ExtentLogger.fail("This is fail step2", true);
    }
}
