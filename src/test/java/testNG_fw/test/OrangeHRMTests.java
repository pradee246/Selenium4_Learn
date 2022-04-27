package testNG_fw.test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testNG_fw.base.BaseTest;
import testNG_fw.pages.OrangeHRMLoginPage;
import testNG_fw.utils.DataProviderUtils;

@Listeners(testNG_fw.listener.Listener.class)	
public final class OrangeHRMTests extends BaseTest{

	private OrangeHRMTests() {}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	void login_logout_test(Map<String, String> data) {
		String sTitle = new OrangeHRMLoginPage().load()
				.enterUserName(data.get("username"))
				.enterPassword(data.get("password"))
				.clickLogin()
				// Logout
				.clickWelcome()
				.clickLogout()
				// Verify Title
				.getPageTitle();

		Assertions.assertThat(sTitle).isEqualTo("OrangeHRM");
	}

	@Test(dataProvider = "LoginTestData")
	void test2(String userName, String password) {
		String sTitle = new OrangeHRMLoginPage()
				.load()
				.enterUserName(userName)
				.enterPassword(password)
				.clickLogin()
				// Logout
				.clickWelcome()
				.clickLogout()
				// Verify Title
				.getPageTitle();

		Assertions.assertThat(sTitle).isEqualTo("OrangeHRM");
	}

	@DataProvider(name="LoginTestData", parallel = true)
	public Object[][] getData(){

		return new Object[][] {
			{"Admin","admin123"},
			{"NotAdmin","notvalid"}
		};
	}
}
